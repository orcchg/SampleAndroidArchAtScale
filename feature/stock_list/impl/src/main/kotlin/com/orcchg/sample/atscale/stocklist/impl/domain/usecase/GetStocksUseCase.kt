package com.orcchg.sample.atscale.stocklist.impl.domain.usecase

import com.orcchg.sample.atscale.base.Params
import com.orcchg.sample.atscale.base.usecase.SingleUseCase
import com.orcchg.sample.atscale.core.schedulers.api.SchedulersFactory
import com.orcchg.sample.atscale.stocklist.api.Stock
import io.reactivex.Single

class GetStocksUseCase(
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<Stock>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<Stock>> =
        Single.just(emptyList())
}