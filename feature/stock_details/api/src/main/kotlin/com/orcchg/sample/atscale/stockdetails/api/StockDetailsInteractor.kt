package com.orcchg.sample.atscale.stockdetails.api

import io.reactivex.Single

interface StockDetailsInteractor {

    fun candles(
        ticker: String,
        resolution: Candle.Resolution,
        fromTs: Long,
        toTs: Long
    ): Single<List<Candle>>
}
