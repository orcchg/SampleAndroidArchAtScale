package com.orcchg.sample.atscale.di

interface ApiContainer {

    fun <T> getFeature(key: Class<T>): T
}

inline fun <reified T> ApiContainer.getFeature(): T =
    getFeature(T::class.java)