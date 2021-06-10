package com.orcchg.sample.atscale.stocklist.data.wiring

import com.orcchg.sample.atscale.stocklist.data.remote.StockListRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object StockListNetworkModule {

    @Provides
    fun rest(retrofit: Retrofit): StockListRest = retrofit.create()
}
