package com.orcchg.sample.atscale.stockdetails.data.api

import com.orcchg.sample.atscale.di.Api

interface StockDetailsDataApi : Api {

    fun repository(): StockDetailsRepository
}
