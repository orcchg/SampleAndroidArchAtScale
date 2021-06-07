package com.orcchg.sample.atscale.util

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.Function

inline fun <reified T> Observable<T>.toSet(): Single<Set<T>> =
    collect({ mutableSetOf() }, { set: MutableSet<T>, next -> set.add(next) }).map { it }

inline fun <reified T> Observable<T>.toListNoDuplicates(): Single<List<T>> =
    toSet().map { it.toList() }

inline fun <reified T> Observable<T>.suppressErrors(
    crossinline cb: (Throwable) -> Unit = {}
): Observable<T> =
    onErrorResumeNext(
        Function {
            cb.invoke(it)
            Observable.empty()
        }
    )

inline fun <reified T> Observable<T>.suppressError(
    crossinline predicate: (Throwable) -> Boolean,
    crossinline cb: (Throwable) -> Unit = {}
): Observable<T> =
    onErrorResumeNext(
        Function { error ->
            if (predicate(error)) {
                cb.invoke(error)
                Observable.empty()
            } else {
                Observable.error(error)
            }
        }
    )
