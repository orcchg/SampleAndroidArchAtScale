package com.orcchg.sample.atscale.stockdetails.fake

import com.orcchg.sample.atscale.stockdetails.api.Candle
import com.orcchg.sample.atscale.stockdetails.api.StockDetailsInteractor
import com.orcchg.sample.atscale.stockdetails.fake.data.mapCandles
import io.reactivex.Single
import javax.inject.Inject

class FakeStockDetailsInteractor @Inject constructor(): StockDetailsInteractor {

    override fun candles(
        ticker: String,
        resolution: Candle.Resolution,
        fromTs: Long,
        toTs: Long
    ): Single<List<Candle>> =
        Single.just(mapCandles[ticker])
}
