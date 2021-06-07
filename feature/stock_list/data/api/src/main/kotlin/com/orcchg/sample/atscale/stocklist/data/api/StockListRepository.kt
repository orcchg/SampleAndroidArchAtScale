package com.orcchg.sample.atscale.stocklist.data.api

import com.orcchg.sample.atscale.stocklist.api.Stock
import io.reactivex.Single

interface StockListRepository {

    fun stocks(): Single<List<Stock>>
}