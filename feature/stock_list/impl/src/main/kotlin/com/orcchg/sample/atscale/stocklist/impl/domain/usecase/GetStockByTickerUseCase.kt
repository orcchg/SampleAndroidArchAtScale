package com.orcchg.sample.atscale.stocklist.impl.domain.usecase

import com.orcchg.sample.atscale.base.Params
import com.orcchg.sample.atscale.base.processMaybe
import com.orcchg.sample.atscale.base.usecase.MaybeUseCase
import com.orcchg.sample.atscale.core.schedulers.api.SchedulersFactory
import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.data.api.StockListRepository
import io.reactivex.Maybe
import javax.inject.Inject

class GetStockByTickerUseCase @Inject constructor(
    private val repository: StockListRepository,
    schedulersFactory: SchedulersFactory
) : MaybeUseCase<Stock>(schedulersFactory) {

    override fun sourceImpl(params: Params): Maybe<Stock> =
        params.processMaybe(PARAM_TICKER, repository::stock)

    companion object {
        const val PARAM_TICKER = "ticker"
    }
}
