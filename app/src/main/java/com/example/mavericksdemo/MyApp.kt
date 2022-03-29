package com.example.mavericksdemo

import android.app.Application
import com.airbnb.mvrx.Mavericks

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}
