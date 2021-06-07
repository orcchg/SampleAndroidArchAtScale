package com.orcchg.sample.atscale.base

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

class Params {

    @PublishedApi internal val map: MutableMap<String, Any?> = mutableMapOf()

    val keys: Set<String>
        get() = map.keys

    @Suppress("UNCHECKED_CAST")
    @PublishedApi internal inline fun <T, R> getOrElse(key: String, body: (p: T) -> R, elseBody: () -> R): R =
        map[key]?.let { body(it as T) } ?: elseBody()

    @Suppress("UNCHECKED_CAST")
    fun <T> get(key: String): T? = map[key] as? T

    fun <T> require(key: String): T =
        getOrElse<T, T>(key, { it }, { throw MissingRequiredParamsException(key) })

    fun put(key: String, value: Any?) {
        map[key] = value
    }

    infix fun String.of(item: Any?) {
        map[this] = item
    }

    override fun toString(): String = map.entries.joinToString { (key, value) -> "[$key:$value]" }

    companion object {
        val EMPTY = Params()
    }
}

// ----------------------------------------------
inline fun <T> Params.processCompletable(key: String, body: (p: T) -> Completable): Completable =
    getOrElse(key, body) { Completable.error(MissingRequiredParamsException(key)) }

inline fun <T, R> Params.processMaybe(key: String, body: (p: T) -> Maybe<R>): Maybe<R> =
    getOrElse(key, body) { Maybe.error(MissingRequiredParamsException(key)) }

inline fun <T, R> Params.processSingle(key: String, body: (p: T) -> Single<R>): Single<R> =
    getOrElse(key, body) { Single.error(MissingRequiredParamsException(key)) }

inline fun <T, R> Params.processFlowable(key: String, body: (p: T) -> Flowable<R>): Flowable<R> =
    getOrElse(key, body) { Flowable.error(MissingRequiredParamsException(key)) }

inline fun <T, R> Params.processObservable(key: String, body: (p: T) -> Observable<R>): Observable<R> =
    getOrElse(key, body) { Observable.error(MissingRequiredParamsException(key)) }

// ----------------------------------------------
inline fun <T> Params.optionalCompletable(key: String, body: (p: T?) -> Completable): Completable = body(get(key))

inline fun <T, R> Params.optionalMaybe(key: String, body: (p: T?) -> Maybe<R>): Maybe<R> = body(get(key))

inline fun <T, R> Params.optionalSingle(key: String, body: (p: T?) -> Single<R>): Single<R> = body(get(key))

inline fun <T, R> Params.optionalFlowable(key: String, body: (p: T?) -> Flowable<R>): Flowable<R> = body(get(key))

inline fun <T, R> Params.optionalObservable(key: String, body: (p: T?) -> Observable<R>): Observable<R> = body(get(key))
