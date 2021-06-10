package com.orcchg.sample.atscale.stocklist.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.orcchg.sample.atscale.stocklist.data.local.model.IssuerDbo
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface IssuerDao {

    // keep issuer if exists, it doesn't change ever
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addIssuer(issuer: IssuerDbo)

    // keep issuer if exists, it doesn't change ever
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addIssuers(issuers: List<IssuerDbo>)

    @Query("SELECT * FROM ${IssuerDbo.TABLE_NAME}")
    fun issuers(): Single<List<IssuerDbo>>

    @Query("SELECT * FROM ${IssuerDbo.TABLE_NAME} WHERE ${IssuerDbo.COLUMN_ID} = :ticker")
    fun issuer(ticker: String): Maybe<IssuerDbo>

    @Query("SELECT EXISTS (SELECT * FROM ${IssuerDbo.TABLE_NAME} WHERE ${IssuerDbo.COLUMN_ID} = :ticker)")
    fun hasIssuer(ticker: String): Boolean

    fun noIssuer(ticker: String): Boolean = !hasIssuer(ticker)
}
