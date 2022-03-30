package com.example.mavericksdemo

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}
