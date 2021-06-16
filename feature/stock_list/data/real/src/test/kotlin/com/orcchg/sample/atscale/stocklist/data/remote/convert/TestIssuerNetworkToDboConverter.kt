package com.orcchg.sample.atscale.stocklist.data.remote.convert

import com.orcchg.sample.atscale.stocklist.data.remote.model.IssuerEntity
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class TestIssuerNetworkToDboConverter {

    @Test
    fun `convert - network data object - dbo object must have same property values`() {
        val entity = IssuerEntity(
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

        val converter = IssuerNetworkToDboConverter()
        val dbo = converter.convert(entity)

        Assert.assertEquals("AAPL", dbo.ticker)
        Assert.assertEquals("Palo Alto", dbo.country)
        Assert.assertEquals("Apple Inc", dbo.name)
        Assert.assertEquals("https://apple.com", dbo.logoUrl)
    }
}
