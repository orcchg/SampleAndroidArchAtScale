package com.orcchg.sample.atscale.di

inline fun <reified T : Api> Map<@JvmSuppressWildcards Class<*>, Api>.get(): T =
    this[T::class.java] as T
