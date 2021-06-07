package com.orcchg.sample.atscale.stocklist.data.api

import com.orcchg.sample.atscale.di.Api

interface StockListDataApi : Api {

    val repository: StockListRepository
}