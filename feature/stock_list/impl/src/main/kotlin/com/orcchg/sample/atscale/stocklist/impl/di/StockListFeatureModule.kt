package com.orcchg.sample.atscale.stocklist.impl.di

import com.orcchg.sample.atscale.stocklist.api.StockListInteractor
import com.orcchg.sample.atscale.stocklist.impl.DefaultStockListInteractor
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface StockListFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: DefaultStockListInteractor): StockListInteractor
}