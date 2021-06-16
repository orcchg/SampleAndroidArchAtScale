package com.orcchg.sample.atscale.util

import io.reactivex.Observable
import io.reactivex.Single

inline fun <reified T> Observable<T>.toSet(): Single<Set<T>> =
    collect({ mutableSetOf() }, { set: MutableSet<T>, next -> set.add(next) }).map { it }
