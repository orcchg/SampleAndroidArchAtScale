package com.orcchg.sample.atscale.app

import com.orcchg.sample.atscale.di.Api
import com.orcchg.sample.atscale.di.get
import com.orcchg.sample.atscale.stocklist.data.api.StockListDataApi
import com.orcchg.sample.atscale.stocklist.data.wiring.DaggerStockListDataComponent
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object DataApiModule {

    @Provides
    @IntoMap
    @ClassKey(StockListDataApi::class)
    @DataApis
    fun stockListDataApi(@CoreApis coreApis: Map<Class<*>, @JvmSuppressWildcards Api>): Api =
        DaggerStockListDataComponent.factory()
            .create(
                contextCoreLibApi = coreApis.get(),
                schedulersCoreLibApi = coreApis.get()
            )
}