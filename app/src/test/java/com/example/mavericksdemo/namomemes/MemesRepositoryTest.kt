@file:OptIn(ExperimentalCoroutinesApi::class)

package com.example.mavericksdemo.namomemes

import com.example.mavericksdemo.TestDispatcherProvider
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.lang.RuntimeException
import java.util.*

class MemesRepositoryTest {

    private val memesService = mock<MemesService>()

    @Test
    fun `fetch memes successfully from remote`() {
        runTest {
            val memes = listOf(Meme("1", "url", Date(2022, 1, 1)))
            whenever(memesService.getMemes())
                .thenReturn(memes)

            val result = repository().fetchMemes()

            assertThat(result)
                .isEqualTo(FetchEvent(FetchStatus.SUCCESSFUL, memes))
        }
    }

    @Test
    fun `fetching memes from remote fails`() {
        runTest {
            val error = ApplicationError("Boom!")
            whenever(memesService.getMemes())
                .thenThrow(RuntimeException("Boom!"))

            val result = repository().fetchMemes()

            assertThat(result)
                .isEqualTo(FetchEvent(FetchStatus.FAILED, emptyList<Meme>(), error))
        }
    }

    private fun TestScope.repository(): MemesRepository =
        MemesRepositoryImpl(memesService, TestDispatcherProvider(testScheduler))
}
