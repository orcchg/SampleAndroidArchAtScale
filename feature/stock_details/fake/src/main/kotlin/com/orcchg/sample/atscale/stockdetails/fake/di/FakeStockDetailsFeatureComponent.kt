package com.orcchg.sample.atscale.stockdetails.fake.di

import com.orcchg.sample.atscale.stockdetails.api.StockDetailsFeatureApi
import dagger.Component

@Component(modules = [FakeStockDetailsInteractorModule::class])
interface FakeStockDetailsFeatureComponent : StockDetailsFeatureApi
