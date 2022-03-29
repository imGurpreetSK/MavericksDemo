package com.example.mavericksdemo.counter

import com.airbnb.mvrx.*
import com.example.mavericksdemo.base.BaseViewModel

class CounterViewModel(
    initialState: CounterState,
    view: CounterView
) : BaseViewModel<CounterState, CounterView>(initialState, view) {

    fun increment() {
        setState { copy(count = count + 1) }
    }

    fun decrement() {
        setState { copy(count = count - 1) }
    }

    // TODO(gs): Can this boilerplate be removed somehow?
    companion object : MavericksViewModelFactory<CounterViewModel, CounterState> {
        override fun create(viewModelContext: ViewModelContext, state: CounterState): CounterViewModel =
            CounterViewModel(state, getView(viewModelContext))
    }
}
