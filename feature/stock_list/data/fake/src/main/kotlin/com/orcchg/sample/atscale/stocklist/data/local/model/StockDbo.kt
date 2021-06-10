package com.orcchg.sample.atscale.stocklist.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.orcchg.sample.atscale.stocklist.data.local.model.StockDbo.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class StockDbo(
    @PrimaryKey @ColumnInfo(name = COLUMN_ID) val ticker: String,
    @ColumnInfo(name = COLUMN_NAME) val name: String,
    @ColumnInfo(name = COLUMN_LOGO_URL) val logoUrl: String? = null,
    @ColumnInfo(name = COLUMN_PRICE_CURRENT) val currentPrice: String,
    @ColumnInfo(name = COLUMN_PRICE_PREV_CLOSE) val prevClosePrice: String
) {

    companion object {
        const val COLUMN_ID = "ticker"
        const val COLUMN_LOGO_URL = "logoUrl"
        const val COLUMN_NAME = "name"
        const val COLUMN_PRICE_CURRENT = "currentPrice"
        const val COLUMN_PRICE_PREV_CLOSE = "prevClosePrice"
        const val TABLE_NAME = "stocks"
    }
}
