package com.orcchg.sample.atscale.stocklist.impl

import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.api.StockListInteractor

class DefaultStockListInteractor : StockListInteractor {

    override fun stocks(): List<Stock> = emptyList()
}