package com.orcchg.sample.atscale.stocklist.api

import io.reactivex.Maybe
import io.reactivex.Single

interface StockListInteractor {

    fun stocks(): Single<List<Stock>>

    fun stock(ticker: String): Maybe<Stock>
}
