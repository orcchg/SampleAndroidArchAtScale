package com.orcchg.sample.atscale.stocklist.data.local.convert

import com.orcchg.sample.atscale.stocklist.data.local.model.IssuerDbo
import com.orcchg.sample.atscale.stocklist.domain.Issuer
import org.junit.Assert
import org.junit.Test

class TestIssuerDboConverter {

    @Test
    fun `convert - data object - domain object must have same property values`() {
        val dbo = IssuerDbo(
            name = "Apple Inc.",
            country = "United States of America",
            ticker = "AAPL",
            logoUrl = "https://apple.com"
        )

        val converter = IssuerDboConverter()
        val issuer = converter.convert(dbo)

        Assert.assertEquals("Apple Inc.", issuer.name)
        Assert.assertEquals("United States of America", issuer.country)
        Assert.assertEquals("AAPL", issuer.ticker)
        Assert.assertEquals("https://apple.com", issuer.logoUrl)
    }

    @Test
    fun `revert - domain object - data object must have same property values`() {
        val issuer = Issuer(
            name = "Apple Inc.",
            country = "United States of America",
            ticker = "AAPL",
            logoUrl = "https://apple.com"
        )

        val converter = IssuerDboConverter()
        val dbo = converter.revert(issuer)

        Assert.assertEquals("Apple Inc.", dbo.name)
        Assert.assertEquals("United States of America", dbo.country)
        Assert.assertEquals("AAPL", dbo.ticker)
        Assert.assertEquals("https://apple.com", dbo.logoUrl)
    }
}
