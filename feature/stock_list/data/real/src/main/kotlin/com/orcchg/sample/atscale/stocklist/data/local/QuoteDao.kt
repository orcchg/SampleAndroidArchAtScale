package com.orcchg.sample.atscale.stocklist.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.orcchg.sample.atscale.stocklist.data.local.model.QuoteDbo
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuote(quote: QuoteDbo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuotes(quotes: List<QuoteDbo>)

    @Query("SELECT * FROM ${QuoteDbo.TABLE_NAME}")
    fun quotes(): Single<List<QuoteDbo>>

    @Query("SELECT * FROM ${QuoteDbo.TABLE_NAME} WHERE ${QuoteDbo.COLUMN_ID} = :ticker")
    fun quote(ticker: String): Maybe<QuoteDbo>
}
