package com.orcchg.sample.atscale.stocklist.demo

import com.orcchg.sample.atscale.stocklist.api.StockListFeatureApi
import com.orcchg.sample.atscale.stocklist.data.api.StockListDataApi
import com.orcchg.sample.atscale.stocklist.ui.di.FakeStockListVoConverterModule
import dagger.Component

@Component(
    modules = [
        FakeStockListVoConverterModule::class,
        TestIntegrationStockListModule::class,
        TestSchedulersModule::class
    ],
    dependencies = [
        StockListDataApi::class
    ]
)
interface TestIntegrationStockListFeatureComponent : StockListFeatureApi {

    fun inject(target: TestIntegrationStockListViewModel)

    @Component.Factory
    interface Factory {
        fun create(
            stockListDataApi: StockListDataApi
        ): TestIntegrationStockListFeatureComponent
    }
}