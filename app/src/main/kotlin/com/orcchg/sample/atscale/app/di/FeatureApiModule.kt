package com.orcchg.sample.atscale.app.di

import com.orcchg.sample.atscale.di.Api
import com.orcchg.sample.atscale.di.get
import com.orcchg.sample.atscale.stockdetails.api.StockDetailsFeatureApi
import com.orcchg.sample.atscale.stockdetails.impl.di.DaggerStockDetailsFeatureComponent
import com.orcchg.sample.atscale.stocklist.api.StockListFeatureApi
import com.orcchg.sample.atscale.stocklist.impl.di.DaggerStockListFeatureComponent
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object FeatureApiModule {

    @Provides
    @Reusable
    @IntoMap
    @ClassKey(StockDetailsFeatureApi::class)
    @FeatureApis
    fun stockDetailsFeatureApi(
        @CoreApis coreApis: Map<Class<*>, @JvmSuppressWildcards Api>,
        @DataApis dataApis: Map<Class<*>, @JvmSuppressWildcards Api>
    ): Api =
        DaggerStockDetailsFeatureComponent.factory()
            .create(
                schedulersCoreLibApi = coreApis.get(),
                stockDetailsDataApi = dataApis.get()
            )

    @Provides
    @Reusable
    @IntoMap
    @ClassKey(StockListFeatureApi::class)
    @FeatureApis
    fun stockListFeatureApi(
        @CoreApis coreApis: Map<Class<*>, @JvmSuppressWildcards Api>,
        @DataApis dataApis: Map<Class<*>, @JvmSuppressWildcards Api>
    ): Api =
        DaggerStockListFeatureComponent.factory()
            .create(
                schedulersCoreLibApi = coreApis.get(),
                stockListDataApi = dataApis.get()
            )
}