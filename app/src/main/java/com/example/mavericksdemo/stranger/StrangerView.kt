package com.example.mavericksdemo.stranger

import com.example.mavericksdemo.base.BaseView

interface StrangerView : BaseView<StrangerState> {

    override fun render(state: StrangerState) {
        if (state.name.isBlank()) {
            renderStrangerGreeting()
        } else {
            renderGreetingWithName(state.name)
        }
    }

    fun renderStrangerGreeting()
    fun renderGreetingWithName(name: String)
}
