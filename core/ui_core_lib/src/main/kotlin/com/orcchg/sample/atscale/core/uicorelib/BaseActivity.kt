package com.orcchg.sample.atscale.core.uicorelib

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.orcchg.sample.atscale.di.ApiContainer

abstract class BaseActivity(@LayoutRes layoutId: Int) : AppCompatActivity(layoutId) {

    protected val api by lazy(LazyThreadSafetyMode.NONE) { application as ApiContainer }
}
