package com.orcchg.sample.atscale.core.schedulers.impl

import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class UseCaseThreadExecutor : Executor {

    private val executor = ThreadPoolExecutor(
        5, 10, 10, TimeUnit.SECONDS,
        LinkedBlockingQueue(), UseCaseThreadFactory(executorName = "$this")
    )

    override fun execute(command: Runnable) {
        executor.execute(command)
    }

    override fun toString(): String = "Ex${hashCode()}"
}

class UseCaseThreadFactory(private val executorName: String) : ThreadFactory {

    override fun newThread(command: Runnable): Thread =
        UseCaseThread(command, "UCThread_$executorName-${INDEX++}")

    companion object {
        private var INDEX = 0
    }
}

private class UseCaseThread(command: Runnable, name: String) : Thread(command, name)
