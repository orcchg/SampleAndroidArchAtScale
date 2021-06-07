package com.orcchg.sample.atscale.stocklist.ui.model

import androidx.annotation.DrawableRes
import com.orcchg.sample.atscale.util.goodHashCode

data class StockVO(
    val name: String,
    val price: String,
    val priceDailyChange: String,
    val ticker: String,
    @DrawableRes val logoResId: Int = 0,
    val logoUrl: String? = null
) {

    fun id(): Long = ticker.goodHashCode()
}
