package com.orcchg.sample.atscale.core.context.impl

import android.app.Application
import android.content.Context
import com.orcchg.sample.atscale.core.context.api.ApplicationContext
import com.orcchg.sample.atscale.core.context.api.ContextCoreLibApi
import dagger.BindsInstance
import dagger.Component

@Component
interface ContextCoreLibComponent : ContextCoreLibApi {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            @BindsInstance @ApplicationContext context: Context
        ): ContextCoreLibComponent
    }
}