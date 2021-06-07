package com.orcchg.sample.atscale.stocklist.api

import com.orcchg.sample.atscale.core.model.Money

data class Stock(
    val name: String,
    val ticker: String,
    val price: Money,
    val priceDailyChange: Money = Money.ZERO,
    val logoUrl: String? = null
) {

    val prevClosePrice: Money = price - priceDailyChange
}
