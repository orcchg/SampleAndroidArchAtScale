package com.orcchg.sample.atscale.base.usecase

import com.orcchg.sample.atscale.base.Params
import com.orcchg.sample.atscale.core.schedulers.api.SchedulersFactory
import io.reactivex.Observable
import io.reactivex.Scheduler

abstract class ObservableUseCase<T>(
    schedulersFactory: SchedulersFactory
) : UseCase(schedulersFactory) {

    abstract fun sourceImpl(params: Params = Params.EMPTY): Observable<T>

    inline fun sourceImpl(initializer: Params.() -> Unit): Observable<T> =
        sourceImpl(Params().apply(initializer))

    fun source(params: Params = Params.EMPTY): Observable<T> =
        sourceImpl(params)
            .subscribeOn(schedulersFactory.useCase())
            .observeOn(schedulersFactory.main())

    inline fun source(initializer: Params.() -> Unit): Observable<T> =
        source(Params().apply(initializer))

    fun source(scheduler: Scheduler, params: Params = Params.EMPTY): Observable<T> =
        sourceImpl(params).subscribeOn(scheduler)

    inline fun source(scheduler: Scheduler, initializer: Params.() -> Unit): Observable<T> =
        source(scheduler, Params().apply(initializer))
}
