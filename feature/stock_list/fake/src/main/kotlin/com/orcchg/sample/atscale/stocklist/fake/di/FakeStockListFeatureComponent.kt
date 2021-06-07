package com.orcchg.sample.atscale.stocklist.fake.di

import com.orcchg.sample.atscale.stocklist.api.StockListFeatureApi
import dagger.Component

@Component(
    modules = [
        FakeStockListFeatureModule::class // publish reasonable alternative for StockListInteractor
    ]
)
interface FakeStockListFeatureComponent : StockListFeatureApi