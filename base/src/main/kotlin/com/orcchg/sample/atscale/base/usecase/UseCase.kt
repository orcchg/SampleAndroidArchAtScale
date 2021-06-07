package com.orcchg.sample.atscale.base.usecase

import com.orcchg.sample.atscale.core.schedulers.api.SchedulersFactory

abstract class UseCase(protected val schedulersFactory: SchedulersFactory)
