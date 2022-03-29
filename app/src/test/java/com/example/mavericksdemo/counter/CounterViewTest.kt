package com.example.mavericksdemo.counter

import androidx.lifecycle.Lifecycle
import com.google.common.truth.Truth.*
import org.junit.Test

class CounterViewTest {

    @Test
    fun `set positive count on view`() {
        val view = FakeCounterView()

        view.render(CounterState(120))

        assertThat(view.counter)
            .isEqualTo(120)
    }

    @Test
    fun `set negative count on view`() {
        val view = FakeCounterView()

        view.render(CounterState(-12))

        assertThat(view.counter)
            .isEqualTo(-12)
    }
}

class FakeCounterView : CounterView {

    var counter: Int = 0

    override fun setCount(count: Int) {
        counter = count
    }

    override fun getLifecycle(): Lifecycle { TODO("Not implemented") }
}
