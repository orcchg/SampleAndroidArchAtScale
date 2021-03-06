package com.orcchg.sample.atscale.app.di

import com.orcchg.sample.atscale.app.App
import com.orcchg.sample.atscale.di.Api
import dagger.Component
import javax.inject.Provider

@Component(
    modules = [
        CoreApiModule::class,
        DataApiModule::class,
        FeatureApiModule::class
    ]
)
interface AppComponent {

    @FeatureApis
    fun featuresMap(): Map<Class<*>, @JvmSuppressWildcards Provider<Api>>

    fun inject(target: App)

    @Component.Factory
    interface Factory {
        fun create(coreApiModule: CoreApiModule): AppComponent
    }
}