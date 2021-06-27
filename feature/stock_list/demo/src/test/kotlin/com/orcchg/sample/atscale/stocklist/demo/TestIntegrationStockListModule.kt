package com.orcchg.sample.atscale.stocklist.demo

import com.orcchg.sample.atscale.stocklist.api.StockListInteractor
import com.orcchg.sample.atscale.stocklist.impl.DefaultStockListInteractor
import dagger.Binds
import dagger.Module

@Module
interface TestIntegrationStockListModule {

    @Binds
    fun interactor(impl: DefaultStockListInteractor): StockListInteractor
}