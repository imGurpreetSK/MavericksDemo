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
        viewModelScope.launch {
            println("ONE: " + repository.getNames())
        }

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                println("TWO: " + repository.getNames())
            }
        }

        viewModelScope.launch {
            val deferred1 = async { println("THREE: 1: " + repository.getNames()) }
            val deferred2 = async { println("THREE: 2: " + repository.getNames()) }
            val deferred3 = async { println("THREE: 3: " + repository.getNames()) }
            deferred1.await()
            deferred2.await()
            deferred3.await()
        }

        setState { copy(name = text) }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<StrangerViewModel, StrangerState>

    companion object : MavericksViewModelFactory<StrangerViewModel, StrangerState> by hiltMavericksViewModelFactory()
}
