package com.orcchg.sample.atscale.stocklist.impl

import com.orcchg.sample.atscale.stocklist.api.Stock
import com.orcchg.sample.atscale.stocklist.api.StockListInteractor
import com.orcchg.sample.atscale.stocklist.impl.domain.usecase.GetStocksUseCase
import io.reactivex.Single

class DefaultStockListInteractor(
    private val getStocksUseCase: GetStocksUseCase
) : StockListInteractor {

    override fun stocks(): Single<List<Stock>> = getStocksUseCase.source()
}