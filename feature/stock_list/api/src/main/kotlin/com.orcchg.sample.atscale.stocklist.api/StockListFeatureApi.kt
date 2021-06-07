package com.orcchg.sample.atscale.stocklist.api

import com.orcchg.sample.atscale.di.Api

interface StockListFeatureApi : Api {

    val interactor: StockListInteractor
}
