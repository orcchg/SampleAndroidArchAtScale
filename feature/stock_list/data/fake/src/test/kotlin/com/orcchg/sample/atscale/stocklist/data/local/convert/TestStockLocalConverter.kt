package com.orcchg.sample.atscale.stocklist.data.local.convert

import com.orcchg.sample.atscale.core.model.money
import com.orcchg.sample.atscale.stocklist.data.local.model.StockDbo
import org.junit.Assert
import org.junit.Test

class TestStockLocalConverter {

    @Test
    fun `convert - data object - domain object must have same property values`() {
        val dbo = StockDbo(
            name = "Apple Inc",
            ticker = "AAPL",
            currentPrice = "$127.01",
            prevClosePrice = "$125.12",
            logoUrl = "https://apple.com"
        )

        val converter = StockLocalConverter()
        val stock = converter.convert(dbo)

        Assert.assertEquals("Apple Inc", stock.name)
        Assert.assertEquals("AAPL", stock.ticker)
        Assert.assertEquals(127.01.money(), stock.price)
        Assert.assertEquals(1.89.money(), stock.priceDailyChange)
        Assert.assertEquals("https://apple.com", stock.logoUrl)
    }
}
