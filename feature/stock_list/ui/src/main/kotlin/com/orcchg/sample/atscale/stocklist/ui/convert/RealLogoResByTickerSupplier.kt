package com.orcchg.sample.atscale.stocklist.ui.convert

import com.orcchg.sample.atscale.util.ResourceSupplier
import javax.inject.Inject

class RealLogoResByTickerSupplier @Inject constructor() : ResourceSupplier {

    // operation not supported for real data
    override fun getResIdByKey(key: String): Int = 0
}
