package com.orcchg.sample.atscale.stocklist.demo

import com.orcchg.sample.atscale.stocklist.data.api.StockListRepository
import dagger.Binds
import dagger.Module

@Module
interface TestStockListRepositoryModule {

    @Binds
    fun repository(fake: FakeStockListRepository): StockListRepository
}