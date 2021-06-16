package com.orcchg.sample.atscale.stocklist.data.local.convert

import com.orcchg.sample.atscale.core.model.money
import com.orcchg.sample.atscale.stocklist.data.local.model.QuoteDbo
import com.orcchg.sample.atscale.stocklist.domain.Quote
import org.junit.Assert
import org.junit.Test

class TestQuoteDboConverter {

    @Test
    fun `convert - data object - domain object must have same property values`() {
        val dbo = QuoteDbo(
            ticker = "AAPL",
            currentPrice = "$127.05",
            maxPrice = "$129.21",
            minPrice = "$126.31",
            openPrice = "$126.91",
            prevClosePrice = "$126.84"
        )

        val converter = QuoteDboConverter()
        val quote = converter.convert(dbo)

        Assert.assertEquals("AAPL", quote.ticker)
        Assert.assertEquals(127.05.money(), quote.currentPrice)
        Assert.assertEquals(129.21.money(), quote.maxPrice)
        Assert.assertEquals(126.31.money(), quote.minPrice)
        Assert.assertEquals(126.91.money(), quote.openPrice)
        Assert.assertEquals(126.84.money(), quote.prevClosePrice)
    }

    @Test
    fun `revert - domain object - data object must have same property values`() {
        val quote = Quote(
            ticker = "AAPL",
            currentPrice = 127.05.money(),
            maxPrice = 129.21.money(),
            minPrice = 126.31.money(),
            openPrice = 126.91.money(),
            prevClosePrice = 126.84.money()
        )

        val converter = QuoteDboConverter()
        val dbo = converter.revert(quote)

        Assert.assertEquals("AAPL", dbo.ticker)
        Assert.assertEquals("$127.05", dbo.currentPrice)
        Assert.assertEquals("$129.21", dbo.maxPrice)
        Assert.assertEquals("$126.31", dbo.minPrice)
        Assert.assertEquals("$126.91", dbo.openPrice)
        Assert.assertEquals("$126.84", dbo.prevClosePrice)
    }
}
