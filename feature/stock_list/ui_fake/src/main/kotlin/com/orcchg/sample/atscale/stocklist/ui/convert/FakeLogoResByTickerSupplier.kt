package com.orcchg.sample.atscale.stocklist.ui.convert

import androidx.annotation.DrawableRes
import com.orcchg.sample.atscale.stocklist.uifake.R
import com.orcchg.sample.atscale.util.ResourceSupplier
import javax.inject.Inject

class FakeLogoResByTickerSupplier @Inject constructor() : ResourceSupplier {

    @DrawableRes
    override fun getResIdByKey(key: String): Int =
        when (key) {
            "AAPL" -> R.drawable.stock_apple_logo
            "APPI" -> R.drawable.stock_appi_logo
            "APPF" -> R.drawable.stock_appfolio_logo
            "APPN" -> R.drawable.stock_appian_logo
            "AMZN" -> R.drawable.stock_amazon_logo
            "BAC" -> R.drawable.stock_bac_logo
            "GOOGL" -> R.drawable.stock_google_logo
            "MA" -> R.drawable.stock_mastercard_logo
            "MSFT" -> R.drawable.stock_microsoft_logo
            "TSLA" -> R.drawable.stock_tesla_logo
            "YNDX" -> R.drawable.stock_yandex_logo
            else -> 0
        }
}
