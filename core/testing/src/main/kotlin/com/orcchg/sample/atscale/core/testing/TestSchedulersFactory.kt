package com.orcchg.sample.atscale.core.testing

import com.orcchg.sample.atscale.core.schedulers.api.SchedulersFactory
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TestSchedulersFactory @Inject constructor() : SchedulersFactory {

    override fun io(): Scheduler = Schedulers.trampoline()

    override fun main(): Scheduler = Schedulers.trampoline()

    override fun useCase(): Scheduler = Schedulers.trampoline()
}