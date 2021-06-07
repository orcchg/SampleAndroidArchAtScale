package com.orcchg.sample.atscale.core.schedulers.impl

import com.orcchg.sample.atscale.core.schedulers.api.SchedulersFactory
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DefaultSchedulersFactory(
    private val useCaseThreadExecutor: UseCaseThreadExecutor
) : SchedulersFactory {

    override fun io(): Scheduler = Schedulers.io()

    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun useCase(): Scheduler = Schedulers.from(useCaseThreadExecutor)
}