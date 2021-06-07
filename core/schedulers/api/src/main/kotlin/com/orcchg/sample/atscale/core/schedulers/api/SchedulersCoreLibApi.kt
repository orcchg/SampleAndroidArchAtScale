package com.orcchg.sample.atscale.core.schedulers.api

import com.orcchg.sample.atscale.di.Api

interface SchedulersCoreLibApi : Api {

    val schedulersFactory: SchedulersFactory
}