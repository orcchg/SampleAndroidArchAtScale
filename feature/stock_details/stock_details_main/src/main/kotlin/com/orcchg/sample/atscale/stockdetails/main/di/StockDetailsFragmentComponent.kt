package com.orcchg.sample.atscale.stockdetails.main.di

import com.orcchg.sample.atscale.stockdetails.api.StockDetailsFeatureApi
import com.orcchg.sample.atscale.stockdetails.api.di.Ticker
import com.orcchg.sample.atscale.stockdetails.main.ui.StockDetailsFragment
import com.orcchg.sample.atscale.stocklist.api.StockListFeatureApi
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        StockDetailsFeatureApi::class,
        StockListFeatureApi::class // dependency
    ]
)
interface StockDetailsFragmentComponent {

    fun inject(target: StockDetailsFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Ticker ticker: String,
            featureApi: StockDetailsFeatureApi,
            stockListFeatureApi: StockListFeatureApi
        ): StockDetailsFragmentComponent
    }
}
