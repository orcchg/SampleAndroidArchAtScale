package com.orcchg.sample.atscale.stockdetails.impl

import com.orcchg.sample.atscale.stockdetails.api.Candle
import com.orcchg.sample.atscale.stockdetails.api.StockDetailsInteractor
import io.reactivex.Single
import javax.inject.Inject

class DefaultStockDetailsInteractor @Inject constructor() : StockDetailsInteractor {

    override fun candles(
        ticker: String,
        resolution: Candle.Resolution,
        fromTs: Long,
        toTs: Long
    ): Single<List<Candle>> =
        Single.just(emptyList())
}
