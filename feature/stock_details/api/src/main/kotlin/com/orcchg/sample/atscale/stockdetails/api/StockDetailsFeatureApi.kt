package com.orcchg.sample.atscale.stockdetails.api

import com.orcchg.sample.atscale.di.Api

interface StockDetailsFeatureApi : Api {

    fun interactor(): StockDetailsInteractor
}
