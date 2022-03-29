package com.example.mavericksdemo.stranger

import androidx.lifecycle.Lifecycle
import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import org.junit.Test

class StrangerViewTest {

    @Test
    fun `render blank state if no name is input`() {
        val view = FakeStrangerView()

        view.render(StrangerState())

        assertThat(view.strangerGreeted)
            .isEqualTo(1)
    }

    @Test
    fun `render state with name if a name is input`() {
        val view = FakeStrangerView()

        view.render(StrangerState("Gurpreet"))

        assertThat(view.strangerName)
            .isEqualTo("Gurpreet")
    }
}

class FakeStrangerView : StrangerView {

    var strangerGreeted = 0
    var strangerName = ""

    override fun renderStrangerGreeting() {
        strangerGreeted++
    }

    override fun renderGreetingWithName(name: String) {
        strangerName = name
    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }
}
