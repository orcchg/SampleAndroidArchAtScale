package com.orcchg.sample.atscale.stockdetails.demo.di

import com.orcchg.sample.atscale.stockdetails.api.StockDetailsFeatureApi
import com.orcchg.sample.atscale.stockdetails.api.di.Ticker
import com.orcchg.sample.atscale.stockdetails.demo.ui.StockDetailsDemoActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        StockDetailsFeatureApi::class
    ]
)
internal interface StockDetailsDemoActivityComponent {

    fun inject(target: StockDetailsDemoActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Ticker ticker: String,
            featureApi: StockDetailsFeatureApi
        ): StockDetailsDemoActivityComponent
    }
}
