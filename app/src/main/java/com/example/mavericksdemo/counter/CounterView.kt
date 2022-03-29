package com.example.mavericksdemo.counter

import com.example.mavericksdemo.base.BaseView

interface CounterView : BaseView {
    fun setCount(count: Int)
}
