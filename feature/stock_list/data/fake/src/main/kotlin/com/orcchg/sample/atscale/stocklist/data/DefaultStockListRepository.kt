package com.orcchg.sample.atscale.stocklist.data

import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.data.api.StockListRepository
import io.reactivex.Single
import javax.inject.Inject

class DefaultStockListRepository @Inject constructor() : StockListRepository {

    override fun stocks(): Single<List<Stock>> = Single.just(emptyList())
}