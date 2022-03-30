package com.example.mavericksdemo.stranger

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.example.mavericksdemo.R
import com.example.mavericksdemo.databinding.StrangerFragmentBinding
import com.example.mavericksdemo.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class StrangerFragment : Fragment(R.layout.stranger_fragment), StrangerView {

    private val binding by viewBinding<StrangerFragmentBinding>()
    private val viewModel: StrangerViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onEach {
            StrangerViewRenderer(this).render(it)
        }

        binding.input.addTextChangedListener {
            it?.let {
                viewModel.onTextChange(it.toString())
            }
        }
    }

    override fun renderStrangerGreeting() {
        binding.output.text = "Hello, stranger!"
    }

    override fun renderGreetingWithName(name: String) {
        binding.output.text = "Hello, $name!"
    }
}
