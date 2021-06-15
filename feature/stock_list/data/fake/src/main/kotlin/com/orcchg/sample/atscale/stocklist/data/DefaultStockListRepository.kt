package com.orcchg.sample.atscale.stocklist.data

import com.orcchg.sample.atscale.core.schedulers.api.SchedulersFactory
import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.data.api.StockListRepository
import com.orcchg.sample.atscale.stocklist.data.local.StockDao
import com.orcchg.sample.atscale.stocklist.data.local.convert.StockLocalConverter
import com.orcchg.sample.atscale.stocklist.data.local.model.StockDbo
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

@Suppress("CheckResult")
class DefaultStockListRepository @Inject constructor(
    private val localStocks: StockDao,
    private val stockLocalConverter: StockLocalConverter,
    schedulersFactory: SchedulersFactory
) : StockListRepository {

    init {
        // fill the local cache with fakes
        Completable.fromAction {
            val stocks = listOf(
                StockDbo(ticker = "AAPL", name = "Apple Inc.", currentPrice = "$122.23", prevClosePrice = "$120.01", logoUrl = "https://finnhub.io/api/logo?symbol=AAPL"),
                StockDbo(ticker = "MSFT", name = "Microsoft Corporation",currentPrice = "$230.5", prevClosePrice = "$234.72", logoUrl = "https://finnhub.io/api/logo?symbol=MSFT"),
                StockDbo(ticker = "T", name = "AT & T", currentPrice = "$30.21", prevClosePrice = "$29.7", logoUrl = "https://finnhub.io/api/logo?symbol=T"),
                StockDbo(ticker = "AMZN", name = "Amazon.com", currentPrice = "$3281.43", prevClosePrice = "$3295.14", logoUrl = "https://finnhub.io/api/logo?symbol=AMZN"),
                StockDbo(ticker = "FB", "Facebook", currentPrice = "$281.99", prevClosePrice = "$283.11", logoUrl = "https://finnhub.io/api/logo?symbol=FB"),
                StockDbo(ticker = "GOOGL", name = "Alphabet Class A", currentPrice = "$1890", prevClosePrice = "$1924.36", logoUrl = "https://finnhub.io/api/logo?symbol=GOOGL"),
                StockDbo(ticker = "AAL", name = "American Airlines", currentPrice = "$21.24", prevClosePrice = "$18.9", logoUrl = "https://finnhub.io/api/logo?symbol=AAL"),
                StockDbo(ticker = "NET", name = "Cloudflare Inc.", currentPrice = "$560", prevClosePrice = "$542.5", logoUrl = "https://finnhub.io/api/logo?symbol=NET"),
                StockDbo(ticker = "TSLA", name = "Tesla Motors", currentPrice = "$599.4", prevClosePrice = "$612.13", logoUrl = "https://finnhub.io/api/logo?symbol=PFE"),
                StockDbo(ticker = "MRNA", name = "Moderna", currentPrice = "$178.4", prevClosePrice = "$133.21", logoUrl = "https://finnhub.io/api/logo?symbol=MRNA")
            )

            localStocks.addStocks(stocks)
        }
            .subscribeOn(schedulersFactory.io())
            .subscribe({}, Timber::e)
    }

    override fun stocks(): Single<List<Stock>> =
        localStocks.stocks().map(stockLocalConverter::convertList)

    override fun stock(ticker: String): Maybe<Stock> =
        localStocks.stock(ticker).map(stockLocalConverter::convert)
}
