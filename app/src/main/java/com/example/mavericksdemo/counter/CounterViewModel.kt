package com.example.mavericksdemo.counter

import com.airbnb.mvrx.*
import com.example.mavericksdemo.base.BaseViewModel

class CounterViewModel(
    initialState: CounterState
) : BaseViewModel<CounterState>(initialState) {

    fun increment() {
        setState { copy(count = count + 1) }
    }

    fun decrement() {
        setState { copy(count = count - 1) }
    }

    companion object : MavericksViewModelFactory<CounterViewModel, CounterState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: CounterState
        ): CounterViewModel = CounterViewModel(state)
    }
}
