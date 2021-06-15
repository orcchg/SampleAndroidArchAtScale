package com.orcchg.sample.atscale.stocklist.impl

import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.api.StockListInteractor
import com.orcchg.sample.atscale.stocklist.impl.domain.usecase.GetStockByTickerUseCase
import com.orcchg.sample.atscale.stocklist.impl.domain.usecase.GetStocksUseCase
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class DefaultStockListInteractor @Inject constructor(
    private val getStocksUseCase: GetStocksUseCase,
    private val getStockByTickerUseCase: GetStockByTickerUseCase
) : StockListInteractor {

    override fun stocks(): Single<List<Stock>> = getStocksUseCase.source()

    override fun stock(ticker: String): Maybe<Stock> =
        getStockByTickerUseCase.source {
            GetStockByTickerUseCase.PARAM_TICKER of ticker
        }
}