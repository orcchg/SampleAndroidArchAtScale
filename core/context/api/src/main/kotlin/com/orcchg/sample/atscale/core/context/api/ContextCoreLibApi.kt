package com.orcchg.sample.atscale.core.context.api

import android.app.Application
import android.content.Context
import com.orcchg.sample.atscale.di.Api

interface ContextCoreLibApi : Api {

    val application: Application

    @ApplicationContext
    val context: Context
}