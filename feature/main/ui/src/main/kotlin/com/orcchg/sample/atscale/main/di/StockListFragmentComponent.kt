package com.orcchg.sample.atscale.main.di

import com.orcchg.sample.atscale.main.ui.StockListFragment
import com.orcchg.sample.atscale.stocklist.api.StockListFeatureApi
import com.orcchg.sample.atscale.stocklist.ui.di.StockListVoConverterModule
import dagger.Component

@Component(
    modules = [
        StockListVoConverterModule::class // real bindings
    ],
    dependencies = [
        StockListFeatureApi::class
    ]
)
interface StockListFragmentComponent {

    fun inject(target: StockListFragment)

    @Component.Factory
    interface Factory {
        fun create(
            featureApi: StockListFeatureApi
        ): StockListFragmentComponent
    }
}
