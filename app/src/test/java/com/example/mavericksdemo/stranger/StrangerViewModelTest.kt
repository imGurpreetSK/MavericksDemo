package com.example.mavericksdemo.stranger

import app.cash.turbine.test
import com.airbnb.mvrx.test.MvRxTestRule
import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock

class StrangerViewModelTest {

    @get:Rule
    val rule = MvRxTestRule()

    @Test
    fun `emit new state on text changes`() = runTest {
        val viewModel = StrangerViewModel(StrangerState(), StrangerViewRenderer(mock()))

        viewModel.stateFlow.test {
            assertThat(awaitItem()).isEqualTo(StrangerState(""))

            viewModel.onTextChange("G")
            assertThat(awaitItem()).isEqualTo(StrangerState("G"))

            viewModel.onTextChange("Gu")
            assertThat(awaitItem()).isEqualTo(StrangerState("Gu"))

            viewModel.onTextChange("G")
            assertThat(awaitItem()).isEqualTo(StrangerState("G"))
        }
    }
}
