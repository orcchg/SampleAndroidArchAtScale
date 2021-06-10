package com.orcchg.sample.atscale.stocklist.di

import com.orcchg.sample.atscale.stocklist.data.local.IssuerDao
import com.orcchg.sample.atscale.stocklist.data.local.QuoteDao
import com.orcchg.sample.atscale.stocklist.data.local.StockListDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object StockListDaoModule {

    @Provides
    @Reusable
    fun stockDao(db: StockListDatabase): IssuerDao = db.issuerDao()

    @Provides
    @Reusable
    fun quoteDao(db: StockListDatabase): QuoteDao = db.quoteDao()
}
