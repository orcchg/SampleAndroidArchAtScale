package com.orcchg.sample.atscale.stocklist.demo

import com.orcchg.sample.atscale.core.schedulers.api.SchedulersFactory
import com.orcchg.sample.atscale.core.testing.TestSchedulersFactory
import dagger.Binds
import dagger.Module

@Module
interface TestSchedulersModule {

    @Binds
    fun schedulersFactory(test: TestSchedulersFactory): SchedulersFactory
}