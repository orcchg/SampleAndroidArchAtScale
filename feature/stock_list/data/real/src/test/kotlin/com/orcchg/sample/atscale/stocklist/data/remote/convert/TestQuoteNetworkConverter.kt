package com.orcchg.sample.atscale.stocklist.data.remote.convert

import com.orcchg.sample.atscale.core.model.money
import com.orcchg.sample.atscale.stocklist.data.remote.model.QuoteEntity
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class TestQuoteNetworkConverter {

    @Test
    fun `convert - network data object and ticker - domain object must have same property values`() {
        val entity = QuoteEntity(
            currentPrice = BigDecimal.valueOf(123.45),
            maxPrice = BigDecimal.valueOf(129.45),
            minPrice = BigDecimal.valueOf(119.85),
            openPrice = BigDecimal.valueOf(122.12),
            prevClosePrice = BigDecimal.valueOf(120.11)
        )

        val converter = QuoteNetworkConverter()
        val quote = converter.convert("AAPL", entity)

        Assert.assertEquals("AAPL", quote.ticker)
        Assert.assertEquals(123.45.money(), quote.currentPrice)
        Assert.assertEquals(129.45.money(), quote.maxPrice)
        Assert.assertEquals(119.85.money(), quote.minPrice)
        Assert.assertEquals(122.12.money(), quote.openPrice)
        Assert.assertEquals(120.11.money(), quote.prevClosePrice)
    }
}
