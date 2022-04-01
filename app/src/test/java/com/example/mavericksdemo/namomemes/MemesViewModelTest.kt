@file:OptIn(ExperimentalCoroutinesApi::class)

package com.example.mavericksdemo.namomemes

import app.cash.turbine.test
import com.airbnb.mvrx.test.MvRxTestRule
import com.example.mavericksdemo.TestDispatcherProvider
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class MemesViewModelTest {

    @get:Rule
    val mvrxRule = MvRxTestRule()

    private val repository = mock<MemesRepository>()

    @Test
    fun `fetching memes successfully returns in-flight and success states`() {
        runTest {
            val viewModel = memesViewModel()

            val data = listOf(Meme("1", "1", Date(2022, 1, 1)))
            whenever(repository.fetchMemes())
                .thenReturn(FetchEvent(FetchStatus.SUCCESSFUL, data))

            viewModel.fetchMemes()

            viewModel.stateFlow.test {
                assertThat(MemesState(FetchStatus.IN_FLIGHT)).isEqualTo(awaitItem())
                assertThat(MemesState(FetchStatus.SUCCESSFUL, data)).isEqualTo(awaitItem())
            }
        }
    }

    @Test
    fun `fetching memes failure returns in-flight and success states`() {
        runTest {
            val viewModel = memesViewModel()

            whenever(repository.fetchMemes())
                .thenReturn(FetchEvent(FetchStatus.FAILED, emptyList(), ApplicationError("Boom!")))

            viewModel.fetchMemes()

            viewModel.stateFlow.test {
                assertThat(MemesState(FetchStatus.IN_FLIGHT)).isEqualTo(awaitItem())
                assertThat(MemesState(FetchStatus.FAILED, error = ApplicationError("Boom!"))).isEqualTo(awaitItem())
            }
        }
    }

    private fun TestScope.memesViewModel() =
        MemesViewModel(MemesState(), repository, TestDispatcherProvider(testScheduler))
}
