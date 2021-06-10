package com.orcchg.sample.atscale.stocklist.data.local.convert

import com.orcchg.sample.atscale.core.model.Money
import com.orcchg.sample.atscale.stocklist.domain.Quote
import com.orcchg.sample.atscale.stocklist.data.local.model.QuoteDbo
import com.orcchg.sample.atscale.util.Converter
import dagger.Reusable
import javax.inject.Inject

@Reusable
class QuoteDboConverter @Inject constructor() : Converter<QuoteDbo, Quote> {

    override fun convert(from: QuoteDbo): Quote =
        Quote(
            ticker = from.ticker,
            currentPrice = Money.parse(from.currentPrice),
            maxPrice = Money.parse(from.maxPrice),
            minPrice = Money.parse(from.minPrice),
            openPrice = Money.parse(from.openPrice),
            prevClosePrice = Money.parse(from.prevClosePrice)
        )

    override fun revert(from: Quote): QuoteDbo =
        QuoteDbo(
            ticker = from.ticker,
            currentPrice = from.currentPrice.toString(),
            maxPrice = from.maxPrice.toString(),
            minPrice = from.minPrice.toString(),
            openPrice = from.openPrice.toString(),
            prevClosePrice = from.prevClosePrice.toString()
        )
}
