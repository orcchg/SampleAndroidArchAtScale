package com.orcchg.sample.atscale.stockdetails.data.wiring

import com.orcchg.sample.atscale.core.network.api.NetworkCoreLibApi
import com.orcchg.sample.atscale.core.schedulers.api.SchedulersCoreLibApi
import com.orcchg.sample.atscale.stockdetails.data.api.StockDetailsDataApi
import dagger.Component

@Component(
    modules = [
        StockDetailsDataModule::class
    ],
    dependencies = [
        NetworkCoreLibApi::class,
        SchedulersCoreLibApi::class
    ]
)
interface StockDetailsDataComponent : StockDetailsDataApi {

    @Component.Factory
    interface Factory {
        fun create(
            networkCoreLibApi: NetworkCoreLibApi,
            schedulersCoreLibApi: SchedulersCoreLibApi
        ): StockDetailsDataComponent
    }
}
