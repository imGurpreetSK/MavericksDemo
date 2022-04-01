package com.example.mavericksdemo.counter

import app.cash.turbine.test
import com.airbnb.mvrx.test.MvRxTestRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock

class CounterViewModelTest {

    @get:Rule
    val mvrxRule = MvRxTestRule()

    @Test
    fun `should increment count`() = runTest {
        val viewModel = CounterViewModel(CounterState(0))

        viewModel.increment()

        assertThat(viewModel.awaitState())
            .isEqualTo(CounterState(1))

    }

    @Test
    fun `should decrement count`() = runTest {
        val viewModel = CounterViewModel(CounterState(10))

        viewModel.decrement()

        viewModel.stateFlow
            .test {
                assertThat(awaitItem())
                    .isEqualTo(CounterState(9))
            }
    }
}
