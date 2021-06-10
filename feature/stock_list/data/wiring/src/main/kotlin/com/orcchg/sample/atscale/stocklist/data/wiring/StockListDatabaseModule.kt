package com.orcchg.sample.atscale.stocklist.data.wiring

import android.content.Context
import androidx.room.Room
import com.orcchg.sample.atscale.core.context.api.ApplicationContext
import com.orcchg.sample.atscale.stocklist.data.local.StockListDatabase
import com.orcchg.sample.atscale.stocklist.di.StockListDaoModule
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(includes = [StockListDaoModule::class])
object StockListDatabaseModule {

    @Provides
    @Reusable
    fun database(@ApplicationContext context: Context): StockListDatabase =
        Room.databaseBuilder(context, StockListDatabase::class.java, StockListDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
}
