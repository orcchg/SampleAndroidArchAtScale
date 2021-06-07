package com.orcchg.sample.atscale.core.schedulers.impl.di

import com.orcchg.sample.atscale.core.schedulers.api.SchedulersCoreLibApi
import dagger.Component

@Component(modules = [SchedulersCoreLibModule::class])
interface SchedulersCoreLibComponent : SchedulersCoreLibApi