package com.example.mavericksdemo.counter

import com.example.mavericksdemo.base.BaseViewRenderer

class CounterViewRenderer(private val view: CounterView) : BaseViewRenderer<CounterState> {

    override fun render(state: CounterState) {
        view.setCount(state.count)
    }
}
