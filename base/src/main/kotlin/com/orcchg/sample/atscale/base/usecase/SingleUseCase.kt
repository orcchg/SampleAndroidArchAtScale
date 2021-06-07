package com.orcchg.sample.atscale.base.usecase

import com.orcchg.sample.atscale.base.Params
import com.orcchg.sample.atscale.core.schedulers.api.SchedulersFactory
import io.reactivex.Scheduler
import io.reactivex.Single

abstract class SingleUseCase<T>(
    schedulersFactory: SchedulersFactory
) : UseCase(schedulersFactory) {

    abstract fun sourceImpl(params: Params = Params.EMPTY): Single<T>

    inline fun sourceImpl(initializer: Params.() -> Unit): Single<T> =
        sourceImpl(Params().apply(initializer))

    fun source(params: Params = Params.EMPTY): Single<T> =
        sourceImpl(params)
            .subscribeOn(schedulersFactory.useCase())
            .observeOn(schedulersFactory.main())

    inline fun source(initializer: Params.() -> Unit): Single<T> =
        source(Params().apply(initializer))

    fun source(scheduler: Scheduler, params: Params = Params.EMPTY): Single<T> =
        sourceImpl(params).subscribeOn(scheduler)

    inline fun source(scheduler: Scheduler, initializer: Params.() -> Unit): Single<T> =
        source(scheduler, Params().apply(initializer))
}
