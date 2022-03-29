package com.example.mavericksdemo.base

import com.airbnb.mvrx.MavericksView

interface BaseView<State> : MavericksView {
    fun render(state: State)

    override fun invalidate() {
        // No-Op
    }
}
