package com.orcchg.sample.atscale.stocklist.data.remote

import com.orcchg.sample.atscale.stocklist.data.remote.model.IssuerEntity
import com.orcchg.sample.atscale.stocklist.data.remote.model.QuoteEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface StockListRest {

    @GET("stock/profile2")
    fun issuer(@Query("symbol") ticker: String): Single<IssuerEntity>

    @GET("quote")
    fun quote(@Query("symbol", encoded = true) ticker: String): Single<QuoteEntity>
}
