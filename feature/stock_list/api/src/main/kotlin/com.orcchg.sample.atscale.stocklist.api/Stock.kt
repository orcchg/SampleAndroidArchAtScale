package com.orcchg.sample.atscale.stocklist.api

import com.orcchg.sample.atscale.core.model.Money

data class Stock(
    val ticker: String,
    val name: String,
    val price: Money,
    val priceDailyChange: Money = Money.ZERO,
    val logoUrl: String? = null,
    val isFavourite: Boolean
) {

    val prevClosePrice: Money = price - priceDailyChange
}