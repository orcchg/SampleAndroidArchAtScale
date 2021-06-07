package com.orcchg.sample.atscale.core.network.impl.di

import com.orcchg.sample.atscale.core.context.api.ContextCoreLibApi
import com.orcchg.sample.atscale.core.network.api.NetworkCoreLibApi
import dagger.Component

@Component(
    modules = [
        NetworkCoreLibModule::class
    ],
    dependencies = [
        ContextCoreLibApi::class
    ]
)
interface NetworkCoreLibComponent : NetworkCoreLibApi {

    @Component.Factory
    interface Factory {
        fun create(contextApi: ContextCoreLibApi): NetworkCoreLibComponent
    }
}