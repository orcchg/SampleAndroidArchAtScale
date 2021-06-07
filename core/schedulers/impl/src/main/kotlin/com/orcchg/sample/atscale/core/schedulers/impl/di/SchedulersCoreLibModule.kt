package com.orcchg.sample.atscale.core.schedulers.impl.di

import com.orcchg.sample.atscale.core.schedulers.api.SchedulersFactory
import com.orcchg.sample.atscale.core.schedulers.impl.DefaultSchedulersFactory
import dagger.Binds
import dagger.Module

@Module
interface SchedulersCoreLibModule {

    @Binds
    fun schedulersFactory(impl: DefaultSchedulersFactory): SchedulersFactory
}