package com.example.mavericksdemo.stranger

import com.google.common.truth.Truth.*
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions

class StrangerViewTest {

    @Test
    fun `render blank state if no name is input`() {
        val view = mock<StrangerView>()
        val renderer = StrangerViewRenderer(view)

        renderer.render(StrangerState())

        verify(view).renderStrangerGreeting()
        verifyNoMoreInteractions(view)
    }

    @Test
    fun `render state with name if a name is input`() {
        val view = mock<StrangerView>()
        val renderer = StrangerViewRenderer(view)

        renderer.render(StrangerState("Gurpreet"))

        verify(view).renderGreetingWithName("Gurpreet")
        verifyNoMoreInteractions(view)
    }
}
