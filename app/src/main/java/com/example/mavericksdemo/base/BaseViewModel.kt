package com.example.mavericksdemo.base

import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.ViewModelContext

abstract class BaseViewModel<State : MavericksState, ViewRenderer : BaseViewRenderer<State>>(
    initialState: State,
    renderer: ViewRenderer
) : MavericksViewModel<State>(initialState) {

    init {
        onEach {
            println("State: $it")
            renderer.render(it)
        }
    }

    companion object {
        fun <V> getView(viewModelContext: ViewModelContext): V where V : BaseView =
            (viewModelContext as FragmentViewModelContext).fragment as V
    }
}
