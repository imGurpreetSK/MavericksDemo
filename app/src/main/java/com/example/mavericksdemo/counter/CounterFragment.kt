package com.example.mavericksdemo.counter

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.fragmentViewModel
import com.example.mavericksdemo.R
import com.example.mavericksdemo.databinding.CounterFragmentBinding
import com.example.mavericksdemo.utils.viewBinding

class CounterFragment : Fragment(R.layout.counter_fragment), CounterView {

    private val viewModel: CounterViewModel by fragmentViewModel()
    private val binding by viewBinding<CounterFragmentBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onEach {
            Log.i("CounterState", "State: $it")
            CounterViewRenderer(this).render(it)
        }

        binding.incrementButton.setOnClickListener { viewModel.increment() }
        binding.decrementButton.setOnClickListener { viewModel.decrement() }
    }

    override fun setCount(count: Int) {
        binding.countTextView.text = count.toString()
    }
}
