package com.example.mavericksdemo

import com.example.mavericksdemo.base.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler

class TestDispatcherProvider(private val testScheduler: TestCoroutineScheduler) : DispatcherProvider {

    override val io: CoroutineDispatcher
        get() = StandardTestDispatcher(testScheduler)

    override val main: CoroutineDispatcher
        get() = StandardTestDispatcher(testScheduler)

    override val computation: CoroutineDispatcher
        get() = StandardTestDispatcher(testScheduler)
}
