package com.orcchg.sample.atscale.stockdetails.data.remote

import com.orcchg.sample.atscale.stockdetails.data.remote.model.CandleListEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface StockDetailsRest {

    @GET("stock/candle")
    fun candles(
        @Query("symbol", encoded = true) ticker: String,
        @Query("resolution") resolution: String,
        @Query("from") fromTs: Long,
        @Query("to") toTs: Long,
    ): Single<CandleListEntity>
}
