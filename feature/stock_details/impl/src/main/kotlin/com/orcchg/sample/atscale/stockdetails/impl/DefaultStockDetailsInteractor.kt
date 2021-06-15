package com.orcchg.sample.atscale.stockdetails.impl

import com.orcchg.sample.atscale.stockdetails.api.Candle
import com.orcchg.sample.atscale.stockdetails.api.StockDetailsInteractor
import com.orcchg.sample.atscale.stockdetails.impl.domain.usecase.GetCandlesByTickerUseCase
import com.orcchg.sample.atscale.stockdetails.impl.domain.usecase.GetCandlesByTickerUseCase.Companion.PARAM_RESOLUTION
import com.orcchg.sample.atscale.stockdetails.impl.domain.usecase.GetCandlesByTickerUseCase.Companion.PARAM_TICKER
import com.orcchg.sample.atscale.stockdetails.impl.domain.usecase.GetCandlesByTickerUseCase.Companion.PARAM_TS_FROM
import com.orcchg.sample.atscale.stockdetails.impl.domain.usecase.GetCandlesByTickerUseCase.Companion.PARAM_TS_TO
import io.reactivex.Single
import javax.inject.Inject

class DefaultStockDetailsInteractor @Inject constructor(
    private val getCandlesByTickerUseCase: GetCandlesByTickerUseCase
) : StockDetailsInteractor {

    override fun candles(
        ticker: String,
        resolution: Candle.Resolution,
        fromTs: Long,
        toTs: Long
    ): Single<List<Candle>> =
        getCandlesByTickerUseCase.source {
            PARAM_TICKER of ticker
            PARAM_RESOLUTION of resolution
            PARAM_TS_FROM of fromTs
            PARAM_TS_TO of toTs
        }
}
