package com.orcchg.sample.atscale.stocklist.impl.di

import com.orcchg.sample.atscale.core.schedulers.api.SchedulersCoreLibApi
import com.orcchg.sample.atscale.stocklist.api.StockListFeatureApi
import com.orcchg.sample.atscale.stocklist.data.api.StockListDataApi
import dagger.Component

@Component(
    modules = [
        StockListFeatureModule::class // publish reasonable alternative for StockListInteractor
    ],
    dependencies = [
        SchedulersCoreLibApi::class,
        StockListDataApi::class
    ]
)
interface StockListFeatureComponent : StockListFeatureApi {

    @Component.Factory
    interface Factory {
        fun create(
            schedulersCoreLibApi: SchedulersCoreLibApi,
            stockListDataApi: StockListDataApi
        ): StockListFeatureComponent
    }
}