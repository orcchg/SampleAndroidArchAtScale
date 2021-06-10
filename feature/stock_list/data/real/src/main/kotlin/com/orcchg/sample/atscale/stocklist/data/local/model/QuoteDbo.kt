package com.orcchg.sample.atscale.stocklist.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.orcchg.sample.atscale.stocklist.data.local.model.QuoteDbo.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class QuoteDbo(
    @PrimaryKey @ColumnInfo(name = COLUMN_ID) val ticker: String,
    @ColumnInfo(name = COLUMN_PRICE_CURRENT) val currentPrice: String,
    @ColumnInfo(name = COLUMN_PRICE_MAX) val maxPrice: String,
    @ColumnInfo(name = COLUMN_PRICE_MIN) val minPrice: String,
    @ColumnInfo(name = COLUMN_PRICE_OPEN) val openPrice: String,
    @ColumnInfo(name = COLUMN_PRICE_PREV_CLOSE) val prevClosePrice: String,
    @ColumnInfo(name = COLUMN_TIMESTAMP) val timestamp: Long = System.currentTimeMillis()
) {

    companion object {
        const val COLUMN_ID = "ticker"
        const val COLUMN_PRICE_CURRENT = "currentPrice"
        const val COLUMN_PRICE_MAX = "maxPrice"
        const val COLUMN_PRICE_MIN = "minPrice"
        const val COLUMN_PRICE_OPEN = "openPrice"
        const val COLUMN_PRICE_PREV_CLOSE = "prevClosePrice"
        const val COLUMN_TIMESTAMP = "ts"
        const val TABLE_NAME = "quotes"
    }
}
