package com.orcchg.sample.atscale.stockdetails.api

import com.orcchg.sample.atscale.core.model.Money

data class Candle(
    val ticker: String,
    val openPrice: Money = Money.ZERO,
    val maxPrice: Money = Money.ZERO,
    val minPrice: Money = Money.ZERO,
    val closePrice: Money = Money.ZERO,
    val resolution: Resolution,
    val volume: Long = 0L,
    val ts: Long = 0L
) {
    enum class Resolution(val v: String) {
        m1("1"), m5("5"), m15("15"), m30("30"), m60("60"),
        Day("D"), Week("W"), Month("M");

        companion object {
            val values = values()

            fun parse(s: String): Resolution =
                values.find { it.v == s } ?: throw IllegalArgumentException("No matching resolution for string: $s")
        }
    }
}
