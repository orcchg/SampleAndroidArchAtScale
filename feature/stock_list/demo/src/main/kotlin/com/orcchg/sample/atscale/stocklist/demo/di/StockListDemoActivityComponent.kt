package com.orcchg.sample.atscale.stocklist.demo.di

import com.orcchg.sample.atscale.stocklist.api.StockListFeatureApi
import com.orcchg.sample.atscale.stocklist.demo.ui.StockListDemoActivity
import com.orcchg.sample.atscale.stocklist.ui.di.FakeStockListVoConverterModule
import dagger.Component

@Component(
    modules = [
        FakeStockListVoConverterModule::class
    ],
    dependencies = [
        StockListFeatureApi::class
    ]
)
internal interface StockListDemoActivityComponent {

    fun inject(target: StockListDemoActivity)

    @Component.Factory
    interface Factory {
        fun create(
            featureApi: StockListFeatureApi
        ): StockListDemoActivityComponent
    }
}