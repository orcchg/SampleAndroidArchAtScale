package com.orcchg.sample.atscale.stockdetails.data

import com.orcchg.sample.atscale.stockdetails.api.Candle
import com.orcchg.sample.atscale.stockdetails.data.api.StockDetailsRepository
import io.reactivex.Single
import javax.inject.Inject

class DefaultStockDetailsRepository @Inject constructor() : StockDetailsRepository {

    override fun candles(
        ticker: String,
        resolution: Candle.Resolution,
        fromTs: Long,
        toTs: Long
    ): Single<List<Candle>> =
        Single.just(emptyList()) // TODO: fake data
}
