package com.orcchg.sample.atscale.stocklist.data.remote.convert

import com.orcchg.sample.atscale.core.model.money
import com.orcchg.sample.atscale.stocklist.domain.Quote
import com.orcchg.sample.atscale.stocklist.data.remote.model.QuoteEntity
import javax.inject.Inject

class QuoteNetworkConverter @Inject constructor() {

    fun convert(ticker: String, from: QuoteEntity): Quote =
        Quote(
            ticker = ticker,
            currentPrice = from.currentPrice.money(),
            maxPrice = from.maxPrice.money(),
            minPrice = from.minPrice.money(),
            openPrice = from.openPrice.money(),
            prevClosePrice = from.prevClosePrice.money()
        )
}
