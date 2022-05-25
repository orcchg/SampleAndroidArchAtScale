package com.orcchg.sample.atscale.app

import android.app.Application
import com.orcchg.sample.atscale.app.di.CoreApiModule
import com.orcchg.sample.atscale.app.di.DaggerAppComponent
import com.orcchg.sample.atscale.app.di.FeatureApis
import com.orcchg.sample.atscale.di.Api
import com.orcchg.sample.atscale.di.ApiContainer
import javax.inject.Inject
import javax.inject.Provider

class App : Application(), ApiContainer {

    @Inject
    @FeatureApis
    lateinit var featuresMap: Map<Class<*>, @JvmSuppressWildcards Provider<Api>>

    @Suppress("Unchecked_Cast")
    override fun <T> getFeature(key: Class<T>): T = featuresMap[key]!!.get() as T

    override fun onCreate() {
        DaggerAppComponent.factory()
            .create(CoreApiModule(application = this))
            .inject(this)
        super.onCreate()
    }
}