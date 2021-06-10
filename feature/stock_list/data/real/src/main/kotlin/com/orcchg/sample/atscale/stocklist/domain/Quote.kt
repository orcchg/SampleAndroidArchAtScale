package com.orcchg.sample.atscale.stocklist.domain

import com.orcchg.sample.atscale.core.model.Money

data class Quote(
    val ticker: String,
    val currentPrice: Money = Money.ZERO,
    val prevClosePrice: Money = Money.ZERO,
    val maxPrice: Money = Money.ZERO,
    val minPrice: Money = Money.ZERO,
    val openPrice: Money = Money.ZERO
) {

    val priceDayChange = currentPrice - prevClosePrice
}
