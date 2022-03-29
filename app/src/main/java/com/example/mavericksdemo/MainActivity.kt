package com.example.mavericksdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mavericksdemo.counter.CounterFragment
import com.example.mavericksdemo.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, CounterFragment(), "CounterFragment")
            .commit()
    }
}
