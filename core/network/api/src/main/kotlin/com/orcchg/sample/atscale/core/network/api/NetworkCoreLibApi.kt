package com.orcchg.sample.atscale.core.network.api

import com.orcchg.sample.atscale.di.Api
import retrofit2.Retrofit

interface NetworkCoreLibApi : Api {

    fun retrofit(): Retrofit
}