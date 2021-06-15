package com.orcchg.sample.atscale.stockdetails.data.wiring

import com.orcchg.sample.atscale.stockdetails.data.DefaultStockDetailsRepository
import com.orcchg.sample.atscale.stockdetails.data.api.StockDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [StockDetailsNetworkModule::class])
interface StockDetailsDataModule {

    @Binds
    @Reusable
    fun repository(impl: DefaultStockDetailsRepository): StockDetailsRepository
}
