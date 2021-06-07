package com.orcchg.sample.atscale.androidutil

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

fun <T> Observable<T>.clickThrottle(timeout: Long = 200L): Observable<T> =
    throttleFirst(timeout, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())