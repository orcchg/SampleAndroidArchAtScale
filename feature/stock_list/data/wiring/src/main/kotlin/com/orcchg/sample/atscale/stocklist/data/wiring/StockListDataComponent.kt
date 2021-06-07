package com.orcchg.sample.atscale.stocklist.data.wiring

import com.orcchg.sample.atscale.core.context.api.ContextCoreLibApi
import com.orcchg.sample.atscale.core.schedulers.api.SchedulersCoreLibApi
import com.orcchg.sample.atscale.stocklist.data.api.StockListDataApi
import dagger.Component

@Component(
    modules = [
        StockListDataModule::class
    ],
    dependencies = [
        ContextCoreLibApi::class,
        SchedulersCoreLibApi::class
    ]
)
interface StockListDataComponent : StockListDataApi {

    @Component.Factory
    interface Factory {
        fun create(
            contextCoreLibApi: ContextCoreLibApi,
            schedulersCoreLibApi: SchedulersCoreLibApi
        ): StockListDataComponent
    }
}