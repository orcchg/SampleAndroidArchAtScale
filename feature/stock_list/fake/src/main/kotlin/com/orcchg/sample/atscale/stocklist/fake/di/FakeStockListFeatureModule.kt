package com.orcchg.sample.atscale.stocklist.fake.di

import com.orcchg.sample.atscale.stocklist.api.StockListInteractor
import com.orcchg.sample.atscale.stocklist.fake.FakeStockListInteractor
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface FakeStockListFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: FakeStockListInteractor): StockListInteractor
}