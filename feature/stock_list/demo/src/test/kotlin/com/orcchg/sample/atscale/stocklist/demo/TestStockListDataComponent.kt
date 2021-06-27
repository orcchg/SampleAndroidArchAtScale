package com.orcchg.sample.atscale.stocklist.demo

import com.orcchg.sample.atscale.core.schedulers.api.SchedulersFactory
import com.orcchg.sample.atscale.stocklist.data.api.StockListDataApi
import dagger.Component

@Component(
    modules = [
        TestStockListRepositoryModule::class,
        TestSchedulersModule::class
    ]
)
interface TestStockListDataComponent : StockListDataApi {

    val schedulersFactory: SchedulersFactory
}