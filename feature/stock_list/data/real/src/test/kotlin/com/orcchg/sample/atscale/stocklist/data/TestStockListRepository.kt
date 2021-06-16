package com.orcchg.sample.atscale.stocklist.data

import com.orcchg.sample.atscale.core.model.money
import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.data.local.IssuerDao
import com.orcchg.sample.atscale.stocklist.data.local.QuoteDao
import com.orcchg.sample.atscale.stocklist.data.local.convert.IssuerDboConverter
import com.orcchg.sample.atscale.stocklist.data.local.convert.QuoteDboConverter
import com.orcchg.sample.atscale.stocklist.data.local.model.IssuerDbo
import com.orcchg.sample.atscale.stocklist.data.local.model.QuoteDbo
import com.orcchg.sample.atscale.stocklist.data.remote.StockListRest
import com.orcchg.sample.atscale.stocklist.data.remote.convert.IssuerNetworkToDboConverter
import com.orcchg.sample.atscale.stocklist.data.remote.convert.QuoteNetworkConverter
import com.orcchg.sample.atscale.stocklist.data.remote.model.IssuerEntity
import com.orcchg.sample.atscale.stocklist.data.remote.model.QuoteEntity
import io.mockk.MockKAnnotations
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Maybe
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal

class TestStockListRepository {

    @MockK
    private lateinit var restCloud: StockListRest

    @MockK
    private lateinit var localIssuer: IssuerDao

    @MockK
    private lateinit var localQuote: QuoteDao

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `get stocks`() {
        //
    }

    @Test
    fun `get stock by ticker`() {
        val ticker = "AAPL"

        every { restCloud.issuer(ticker) } returns
            Single.just(
                IssuerEntity(
                    country = "Palo Alto",
                    currency = "USD",
                    exchange = "NASDAQ",
                    ipoDate = "1980",
                    marketCap = BigDecimal.TEN,
                    name = "Apple Inc",
                    phone = "+1 200 400 5050",
                    shares = BigDecimal.ZERO,
                    ticker = "AAPL",
                    webUrl = "https://apple.com",
                    logoUrl = "https://apple.com",
                    industry = "IT"
                )
            )

        every { restCloud.quote(ticker) } returns
            Single.just(
                QuoteEntity(
                    currentPrice = BigDecimal.valueOf(127.05),
                    maxPrice = BigDecimal.valueOf(129.21),
                    minPrice = BigDecimal.valueOf(126.31),
                    openPrice = BigDecimal.valueOf(126.91),
                    prevClosePrice = BigDecimal.valueOf(126.84)
                )
            )

        every { localIssuer.issuer(ticker) } returns
            Maybe.just(
                IssuerDbo(
                    name = "Apple Inc",
                    country = "Palo Alto",
                    ticker = "AAPL",
                    logoUrl = "https://apple.com"
                )
            )

        every { localQuote.quote(ticker) } returns
            Maybe.just(
                QuoteDbo(
                    ticker = "AAPL",
                    currentPrice = "$127.05",
                    maxPrice = "$129.21",
                    minPrice = "$126.31",
                    openPrice = "$126.91",
                    prevClosePrice = "$126.84"
                )
            )

        val repository = DefaultStockListRepository(
            restCloud = restCloud,
            localIssuer = localIssuer,
            localQuote = localQuote,
            issuerLocalConverter = IssuerDboConverter(),
            issuerNetworkToLocalConverter = IssuerNetworkToDboConverter(),
            quoteLocalConverter = QuoteDboConverter(),
            quoteNetworkConverter = QuoteNetworkConverter()
        )

        val stockSource = repository.stock(ticker).test()
        stockSource
            .assertNoErrors()
            .assertComplete()
            .assertValue(
                Stock(
                    name = "Apple Inc",
                    ticker = ticker,
                    price = 127.05.money(),
                    priceDailyChange = 0.21.money(),
                    logoUrl = "https://apple.com"
                )
            )

        verify(inverse = true) { restCloud.issuer(ticker) }
        verify(exactly = 1) { restCloud.quote(ticker) }
        verify(exactly = 1) { localIssuer.issuer(ticker) }
        verify(exactly = 1) { localQuote.quote(ticker) }
        confirmVerified(restCloud)
        confirmVerified(localIssuer)
        confirmVerified(localQuote)
    }
}
