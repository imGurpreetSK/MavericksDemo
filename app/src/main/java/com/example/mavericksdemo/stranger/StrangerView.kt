package com.example.mavericksdemo.stranger

import com.example.mavericksdemo.base.BaseView

interface StrangerView : BaseView {
    fun renderStrangerGreeting()
    fun renderGreetingWithName(name: String)
}
