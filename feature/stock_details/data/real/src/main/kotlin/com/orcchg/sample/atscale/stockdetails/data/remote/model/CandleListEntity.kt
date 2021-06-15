package com.orcchg.sample.atscale.stockdetails.data.remote.model

import com.squareup.moshi.Json
import java.math.BigDecimal

data class CandleListEntity(
    @Json(name = "o") val openPrice: List<BigDecimal> = emptyList(),
    @Json(name = "h") val maxPrice: List<BigDecimal> = emptyList(),
    @Json(name = "l") val minPrice: List<BigDecimal> = emptyList(),
    @Json(name = "c") val closePrice: List<BigDecimal> = emptyList(),
    @Json(name = "v") val volume: List<Long> = emptyList(),
    @Json(name = "t") val ts: List<Long> = emptyList(),
    @Json(name = "s") val status: String
)
