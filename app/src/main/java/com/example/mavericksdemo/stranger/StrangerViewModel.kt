package com.example.mavericksdemo.stranger

import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.example.mavericksdemo.base.BaseViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StrangerViewModel @AssistedInject constructor(
    @Assisted initialState: StrangerState,
    private val repository: Repository
) : BaseViewModel<StrangerState>(initialState) {

    fun onTextChange(text: String) {
        setState { copy(name = text) }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<StrangerViewModel, StrangerState>

    companion object : MavericksViewModelFactory<StrangerViewModel, StrangerState> by hiltMavericksViewModelFactory()
}
