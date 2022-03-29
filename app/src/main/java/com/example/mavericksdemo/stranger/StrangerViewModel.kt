package com.example.mavericksdemo.stranger

import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.mavericksdemo.base.BaseViewModel

class StrangerViewModel(
    initialState: StrangerState,
    view: StrangerViewRenderer
) : BaseViewModel<StrangerState, StrangerViewRenderer>(initialState, view) {

    fun onTextChange(text: String) {
        setState { copy(name = text) }
    }

    companion object : MavericksViewModelFactory<StrangerViewModel, StrangerState> {
        override fun create(viewModelContext: ViewModelContext, state: StrangerState): StrangerViewModel =
            StrangerViewModel(state, StrangerViewRenderer(getView(viewModelContext)))
    }
}
