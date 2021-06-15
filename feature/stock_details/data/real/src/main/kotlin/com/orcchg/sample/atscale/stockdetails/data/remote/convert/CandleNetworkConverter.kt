package com.orcchg.sample.atscale.stockdetails.data.remote.convert

import com.orcchg.sample.atscale.core.model.money
import com.orcchg.sample.atscale.stockdetails.api.Candle
import com.orcchg.sample.atscale.stockdetails.data.remote.model.CandleListEntity
import javax.inject.Inject

class CandleNetworkConverter @Inject constructor() {

    fun convert(
        ticker: String,
        resolution: Candle.Resolution,
        from: CandleListEntity
    ): List<Candle> =
        mutableListOf<Candle>().apply {
            val length = from.volume.size
            for (i in 0 until length) {
                add(
                    Candle(
                        ticker = ticker,
                        openPrice = from.openPrice[i].money(),
                        maxPrice = from.maxPrice[i].money(),
                        minPrice = from.minPrice[i].money(),
                        closePrice = from.closePrice[i].money(),
                        resolution = resolution,
                        volume = from.volume[i],
                        ts = from.ts[i]
                    )
                )
            }
        }
}
