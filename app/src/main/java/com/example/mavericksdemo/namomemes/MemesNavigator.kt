package com.example.mavericksdemo.namomemes

import androidx.fragment.app.FragmentManager
import com.example.mavericksdemo.R
import com.example.mavericksdemo.counter.CounterFragment

class MemesNavigator(private val parentFragmentManager: FragmentManager) {

    fun navigate() {
        val tag = "counter fragment"
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CounterFragment(), tag)
            .addToBackStack(tag)
            .commit()
    }
}
