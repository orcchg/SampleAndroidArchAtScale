package com.orcchg.sample.atscale.stockdetails.data.api

import com.orcchg.sample.atscale.stockdetails.api.Candle
import io.reactivex.Single

interface StockDetailsRepository {

    fun candles(
        ticker: String,
        resolution: Candle.Resolution,
        fromTs: Long,
        toTs: Long
    ): Single<List<Candle>>
}
