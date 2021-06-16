package com.orcchg.sample.atscale.stocklist.ui.convert

import com.orcchg.sample.atscale.core.model.money
import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.util.ResourceSupplier
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestStockVoConverter {

    @MockK
    private lateinit var logoResSupplier: ResourceSupplier

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `convert - domain object - view object must have same property values`() {
        val stock = Stock(
            name = "Apple",
            price = 127.91.money(),
            priceDailyChange = 1.82.money(),
            ticker = "AAPL",
            logoUrl = "https://apple.com"
        )

        every { logoResSupplier.getResIdByKey("AAPL") } returns 101

        val converter = StockVoConverter(logoResSupplier)
        val vo = converter.convert(stock)

        Assert.assertEquals("Apple", vo.name)
        Assert.assertEquals("$127.91", vo.price)
        Assert.assertEquals("+$1.82 (1.42%)", vo.priceDailyChange)
        Assert.assertEquals("AAPL", vo.ticker)
        Assert.assertEquals(101, vo.logoResId)
        Assert.assertEquals("https://apple.com", vo.logoUrl)
    }
}
