package com.orcchg.sample.atscale.stockdetails.impl.di

import com.orcchg.sample.atscale.stockdetails.api.StockDetailsFeatureApi
import dagger.Component

@Component(
    modules = [
        StockDetailsInteractorModule::class
    ]
)
interface StockDetailsFeatureComponent : StockDetailsFeatureApi {

    @Component.Factory
    interface Factory {
        fun create(): StockDetailsFeatureComponent
    }
}
