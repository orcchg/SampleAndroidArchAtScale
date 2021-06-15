package com.orcchg.sample.atscale.stockdetails.impl.di

import com.orcchg.sample.atscale.stockdetails.api.StockDetailsInteractor
import com.orcchg.sample.atscale.stockdetails.impl.DefaultStockDetailsInteractor
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface StockDetailsInteractorModule {

    @Binds
    @Reusable
    fun interactor(impl: DefaultStockDetailsInteractor): StockDetailsInteractor
}
