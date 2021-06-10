package com.orcchg.sample.atscale.stocklist.data.remote.model

import com.squareup.moshi.Json
import java.math.BigDecimal

data class IssuerEntity(
    @Json(name = "country") val country: String,
    @Json(name = "currency") val currency: String,
    @Json(name = "exchange") val exchange: String,
    @Json(name = "ipo") val ipoDate: String,
    @Json(name = "marketCapitalization") val marketCap: BigDecimal,
    @Json(name = "name") val name: String,
    @Json(name = "phone") val phone: String,
    @Json(name = "shareOutstanding") val shares: BigDecimal,
    @Json(name = "ticker") val ticker: String,
    @Json(name = "weburl") val webUrl: String?,
    @Json(name = "logo") val logoUrl: String?,
    @Json(name = "finnhubIndustry") val industry: String
)
