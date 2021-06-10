package com.orcchg.sample.atscale.stocklist.data.wiring

import com.orcchg.sample.atscale.stocklist.data.DefaultStockListRepository
import com.orcchg.sample.atscale.stocklist.data.api.StockListRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(
    includes = [
        StockListDatabaseModule::class,
        StockListNetworkModule::class
    ]
)
interface StockListDataModule {

    @Binds
    @Reusable
    fun repository(impl: DefaultStockListRepository): StockListRepository
}