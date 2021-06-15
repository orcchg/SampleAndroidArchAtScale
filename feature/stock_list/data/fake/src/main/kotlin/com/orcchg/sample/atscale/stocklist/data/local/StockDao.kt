package com.orcchg.sample.atscale.stocklist.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.orcchg.sample.atscale.stocklist.data.local.model.StockDbo
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface StockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addStocks(stocks: List<StockDbo>)

    @Query("SELECT * FROM ${StockDbo.TABLE_NAME}")
    fun stocks(): Single<List<StockDbo>>

    @Query("SELECT * FROM ${StockDbo.TABLE_NAME} WHERE ${StockDbo.COLUMN_ID} = :ticker")
    fun stock(ticker: String): Maybe<StockDbo>
}
