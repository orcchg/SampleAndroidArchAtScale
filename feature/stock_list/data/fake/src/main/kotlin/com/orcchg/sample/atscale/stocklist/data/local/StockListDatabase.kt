package com.orcchg.sample.atscale.stocklist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.orcchg.sample.atscale.stocklist.data.local.model.StockDbo

@Database(entities = [StockDbo::class], version = 1)
abstract class StockListDatabase : RoomDatabase() {

    abstract fun stockDao(): StockDao

    companion object {
        const val DATABASE_NAME = "FakeStockList.db"
    }
}
