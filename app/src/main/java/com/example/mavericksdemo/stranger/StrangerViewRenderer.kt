package com.example.mavericksdemo.stranger

import com.example.mavericksdemo.base.BaseViewRenderer

class StrangerViewRenderer(private val view: StrangerView) : BaseViewRenderer<StrangerState> {

    override fun render(state: StrangerState) {
        if (state.name.isBlank()) {
            view.renderStrangerGreeting()
        } else {
            view.renderGreetingWithName(state.name)
        }
    }
}
