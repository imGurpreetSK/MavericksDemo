package com.example.mavericksdemo.base

import com.airbnb.mvrx.MavericksState

interface BaseViewRenderer<State : MavericksState> {
    fun render(state: State)
}
