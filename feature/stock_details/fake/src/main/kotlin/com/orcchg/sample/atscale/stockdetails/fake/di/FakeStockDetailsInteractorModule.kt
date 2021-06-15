package com.orcchg.sample.atscale.stockdetails.fake.di

import com.orcchg.sample.atscale.stockdetails.api.StockDetailsInteractor
import com.orcchg.sample.atscale.stockdetails.fake.FakeStockDetailsInteractor
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface FakeStockDetailsInteractorModule {

    @Binds
    @Reusable
    fun interactor(impl: FakeStockDetailsInteractor): StockDetailsInteractor
}
