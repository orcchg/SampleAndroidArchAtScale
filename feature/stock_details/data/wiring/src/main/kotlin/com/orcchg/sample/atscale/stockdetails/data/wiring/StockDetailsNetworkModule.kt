package com.orcchg.sample.atscale.stockdetails.data.wiring

import com.orcchg.sample.atscale.stockdetails.data.remote.StockDetailsRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object StockDetailsNetworkModule {

    @Provides
    fun rest(retrofit: Retrofit): StockDetailsRest = retrofit.create()
}
