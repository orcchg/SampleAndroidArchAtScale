package com.orcchg.sample.atscale.stocklist.data

import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.data.api.StockListRepository
import io.reactivex.Single

class DefaultStockListRepository : StockListRepository {

    override fun stocks(): Single<List<Stock>> = Single.just(emptyList())
}