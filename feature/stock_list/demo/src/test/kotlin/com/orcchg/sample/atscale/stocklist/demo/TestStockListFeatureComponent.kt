package com.orcchg.sample.atscale.stocklist.demo

import com.orcchg.sample.atscale.stocklist.api.StockListFeatureApi
import com.orcchg.sample.atscale.stocklist.fake.di.FakeStockListFeatureModule
import com.orcchg.sample.atscale.stocklist.ui.di.FakeStockListVoConverterModule
import dagger.Component

@Component(
    modules = [
        FakeStockListVoConverterModule::class,
        FakeStockListFeatureModule::class
    ]
)
interface TestStockListFeatureComponent : StockListFeatureApi {

    fun inject(target: TestStockListViewModel)
}