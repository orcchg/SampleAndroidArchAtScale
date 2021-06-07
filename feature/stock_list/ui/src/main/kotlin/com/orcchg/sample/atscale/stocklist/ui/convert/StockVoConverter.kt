package com.orcchg.sample.atscale.stocklist.ui.convert

import com.orcchg.sample.atscale.core.model.formatPriceChange
import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.ui.model.StockVO
import com.orcchg.sample.atscale.util.Converter
import com.orcchg.sample.atscale.util.ResourceSupplier
import javax.inject.Inject

class StockVoConverter @Inject constructor(
    private val logoResSupplier: ResourceSupplier
) : Converter<Stock, StockVO> {

    override fun convert(from: Stock): StockVO =
        StockVO(
            name = from.name,
            price = from.price.toString(),
            priceDailyChange = formatPriceChange(from.price, from.priceDailyChange),
            ticker = from.ticker,
            logoResId = logoResSupplier.getResIdByKey(from.ticker),
            logoUrl = from.logoUrl
        )
}
