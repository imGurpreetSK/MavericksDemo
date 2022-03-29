package com.example.mavericksdemo.base

import android.util.Log
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.ViewModelContext

abstract class BaseViewModel<State : MavericksState, View : BaseView<State>>(
    initialState: State,
    view: View
) : MavericksViewModel<State>(initialState) {

    init {
        onEach {
            Log.i("State: ", it.toString())
            view.render(it)
        }
    }

    companion object {
        fun <T> getView(viewModelContext: ViewModelContext): T =
            (viewModelContext as FragmentViewModelContext).fragment as T
    }
}
