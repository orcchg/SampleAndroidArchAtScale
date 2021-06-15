package com.orcchg.sample.atscale.stockdetails.impl.di

import com.orcchg.sample.atscale.core.schedulers.api.SchedulersCoreLibApi
import com.orcchg.sample.atscale.stockdetails.api.StockDetailsFeatureApi
import com.orcchg.sample.atscale.stockdetails.data.api.StockDetailsDataApi
import dagger.Component

@Component(
    modules = [
        StockDetailsInteractorModule::class
    ],
    dependencies = [
        SchedulersCoreLibApi::class,
        StockDetailsDataApi::class
    ]
)
interface StockDetailsFeatureComponent : StockDetailsFeatureApi {

    @Component.Factory
    interface Factory {
        fun create(
            schedulersCoreLibApi: SchedulersCoreLibApi,
            stockDetailsDataApi: StockDetailsDataApi
        ): StockDetailsFeatureComponent
    }
}
