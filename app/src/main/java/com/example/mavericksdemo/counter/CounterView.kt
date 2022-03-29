package com.example.mavericksdemo.counter

import com.example.mavericksdemo.base.BaseView

interface CounterView : BaseView<CounterState> {

    fun setCount(count: Int)

    override fun render(state: CounterState) {
        setCount(state.count)
    }
}
