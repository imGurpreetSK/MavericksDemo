package com.example.mavericksdemo.stranger

import com.airbnb.mvrx.MavericksState

data class StrangerState(
    val name: String = ""
) : MavericksState
