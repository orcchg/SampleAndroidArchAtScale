package com.orcchg.sample.atscale.androidutil

import androidx.fragment.app.Fragment

@Suppress("Unchecked_Cast")
fun <T : Any> Fragment.argument(key: String) =
    lazy(LazyThreadSafetyMode.NONE) { requireArguments().get(key) as T }
