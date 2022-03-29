package com.example.mavericksdemo.base

import com.airbnb.mvrx.MavericksView

interface BaseView : MavericksView {
    override fun invalidate() {
        // No-Op
    }
}
