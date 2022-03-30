package com.example.mavericksdemo.stranger

import com.airbnb.mvrx.*
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.CreateMavericksViewModelComponent
import com.airbnb.mvrx.hilt.HiltMavericksEntryPoint
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.example.mavericksdemo.base.BaseViewModel
import com.example.mavericksdemo.base.BaseViewRenderer
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.EntryPoints

class StrangerViewModel @AssistedInject constructor(
    @Assisted initialState: StrangerState,
    private val repository: Repository
) : BaseViewModel<StrangerState>(initialState) {

    fun onTextChange(text: String) {
        repository.dummy(text)
        setState { copy(name = text) }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<StrangerViewModel, StrangerState> {
        override fun create(state: StrangerState): StrangerViewModel
    }

    companion object : MavericksViewModelFactory<StrangerViewModel, StrangerState> by hiltMavericksViewModelFactory()
}
