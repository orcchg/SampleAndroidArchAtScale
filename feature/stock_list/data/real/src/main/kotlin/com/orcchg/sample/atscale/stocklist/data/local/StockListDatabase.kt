package com.orcchg.sample.atscale.stocklist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.orcchg.sample.atscale.stocklist.data.local.model.IssuerDbo
import com.orcchg.sample.atscale.stocklist.data.local.model.QuoteDbo

@Database(entities = [IssuerDbo::class, QuoteDbo::class], version = 1)
abstract class StockListDatabase : RoomDatabase() {

    abstract fun issuerDao(): IssuerDao
    abstract fun quoteDao(): QuoteDao

    companion object {
        const val DATABASE_NAME = "StockList.db"
    }
}
