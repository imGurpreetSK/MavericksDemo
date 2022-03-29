package com.example.mavericksdemo.counter

import androidx.lifecycle.Lifecycle
import com.google.common.truth.Truth.*
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class CounterViewTest {

    @Test
    fun `set positive count on view`() {
        val view = mock<CounterView>()
        val renderer = CounterViewRenderer(view)

        renderer.render(CounterState(120))

        verify(view).setCount(120)
    }

    @Test
    fun `set negative count on view`() {
        val view = mock<CounterView>()
        val renderer = CounterViewRenderer(view)

        renderer.render(CounterState(-12))

        verify(view).setCount(-12)
    }
}
