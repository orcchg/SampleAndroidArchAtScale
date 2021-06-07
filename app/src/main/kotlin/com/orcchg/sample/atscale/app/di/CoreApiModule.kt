package com.orcchg.sample.atscale.app.di

import android.app.Application
import com.orcchg.sample.atscale.core.context.api.ContextCoreLibApi
import com.orcchg.sample.atscale.core.context.impl.DaggerContextCoreLibComponent
import com.orcchg.sample.atscale.core.schedulers.api.SchedulersCoreLibApi
import com.orcchg.sample.atscale.core.schedulers.impl.di.DaggerSchedulersCoreLibComponent
import com.orcchg.sample.atscale.di.Api
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class CoreApiModule(private val application: Application) {

    private val contextApi: ContextCoreLibApi by lazy(LazyThreadSafetyMode.NONE) {
        DaggerContextCoreLibComponent.factory().create(application, application.applicationContext)
    }

    @Provides
    @IntoMap
    @ClassKey(ContextCoreLibApi::class)
    @CoreApis
    fun contextApi(): Api = contextApi

    @Provides
    @IntoMap
    @ClassKey(SchedulersCoreLibApi::class)
    @CoreApis
    fun schedulersApi(): Api = DaggerSchedulersCoreLibComponent.create()
}