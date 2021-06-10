package com.orcchg.sample.atscale.stocklist.data.local.convert

import com.orcchg.sample.atscale.core.model.Money
import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.data.local.model.StockDbo
import com.orcchg.sample.atscale.util.Converter
import javax.inject.Inject

class StockLocalConverter @Inject constructor() : Converter<StockDbo, Stock> {

    override fun convert(from: StockDbo): Stock {
        val price = Money.parse(from.currentPrice)
        val priceDailyChange = price - Money.parse(from.prevClosePrice)

        return Stock(
            name = from.name,
            ticker = from.ticker,
            price = price,
            priceDailyChange = priceDailyChange,
            logoUrl = from.logoUrl
        )
    }
}
