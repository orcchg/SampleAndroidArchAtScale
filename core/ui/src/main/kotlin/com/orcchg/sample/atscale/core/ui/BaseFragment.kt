package com.orcchg.sample.atscale.core.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.orcchg.sample.atscale.di.ApiContainer

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    protected val api by lazy(LazyThreadSafetyMode.NONE) { requireActivity().application as ApiContainer }
}
