package com.example.mavericksdemo.namomemes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.airbnb.mvrx.fragmentViewModel
import com.example.mavericksdemo.R
import com.example.mavericksdemo.databinding.MemesFragmentBinding
import com.example.mavericksdemo.utils.viewBinding
import kotlinx.coroutines.launch

class MemesFragment : Fragment(R.layout.memes_fragment), MemesView {

    private val binding by viewBinding<MemesFragmentBinding>()
    private val viewModel: MemesViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onEach {
            println("State: $it")
            MemesViewRenderer(this).render(it)
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.fetchMemes()
            }
        }
    }

    override fun showLoading() {
        Toast.makeText(context, "showLoading", Toast.LENGTH_SHORT).show()
    }

    override fun showMemes(memes: List<Meme>) {
        Toast.makeText(context, "showMemes: ${memes.size}", Toast.LENGTH_SHORT).show()
        MemesNavigator(parentFragmentManager).navigate()
    }

    override fun showError(error: ApplicationError) {
        Toast.makeText(context, "showError: ${error.message}", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        Toast.makeText(context, "hideLoading", Toast.LENGTH_SHORT).show()
    }

    override fun hideMemes() {
        Toast.makeText(context, "hideMemes", Toast.LENGTH_SHORT).show()
    }

    override fun hideError() {
        Toast.makeText(context, "hideError", Toast.LENGTH_SHORT).show()
    }
}
