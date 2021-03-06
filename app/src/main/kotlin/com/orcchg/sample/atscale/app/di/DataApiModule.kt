package com.orcchg.sample.atscale.app.di

import com.orcchg.sample.atscale.di.Api
import com.orcchg.sample.atscale.di.get
import com.orcchg.sample.atscale.stockdetails.data.api.StockDetailsDataApi
import com.orcchg.sample.atscale.stockdetails.data.wiring.DaggerStockDetailsDataComponent
import com.orcchg.sample.atscale.stocklist.data.api.StockListDataApi
import com.orcchg.sample.atscale.stocklist.data.wiring.DaggerStockListDataComponent
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object DataApiModule {

    @Provides
    @Reusable
    @IntoMap
    @ClassKey(StockDetailsDataApi::class)
    @DataApis
    fun stockDetailsDataApi(@CoreApis coreApis: Map<Class<*>, @JvmSuppressWildcards Api>): Api =
        DaggerStockDetailsDataComponent.factory()
            .create(
                networkCoreLibApi = coreApis.get(),
                schedulersCoreLibApi = coreApis.get()
            )

    @Provides
    @Reusable
    @IntoMap
    @ClassKey(StockListDataApi::class)
    @DataApis
    fun stockListDataApi(@CoreApis coreApis: Map<Class<*>, @JvmSuppressWildcards Api>): Api =
        DaggerStockListDataComponent.factory()
            .create(
                contextCoreLibApi = coreApis.get(),
                networkCoreLibApi = coreApis.get(),
                schedulersCoreLibApi = coreApis.get()
            )
}