package com.orcchg.sample.atscale.stocklist.di

import com.orcchg.sample.atscale.stocklist.data.local.StockDao
import com.orcchg.sample.atscale.stocklist.data.local.StockListDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object StockListDaoModule {

    @Provides
    @Reusable
    fun stockDao(db: StockListDatabase): StockDao = db.stockDao()
}
