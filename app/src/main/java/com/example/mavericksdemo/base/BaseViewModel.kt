package com.example.mavericksdemo.base

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel

abstract class BaseViewModel<State : MavericksState>(
    initialState: State
) : MavericksViewModel<State>(initialState)
