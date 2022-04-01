package com.example.mavericksdemo.namomemes

import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.example.mavericksdemo.base.BaseViewModel
import com.example.mavericksdemo.base.DispatcherProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MemesViewModel @AssistedInject constructor(
    @Assisted initialState: MemesState,
    private val repository: MemesRepository,
    private val dispatcherProvider: DispatcherProvider
) : BaseViewModel<MemesState>(initialState) {

    fun fetchMemes() {
        viewModelScope.launch {
            withContext(dispatcherProvider.io) {
                setState { copy(status = FetchStatus.IN_FLIGHT) }

                val result = repository.fetchMemes()
                setState { copy(status = result.fetchStatus, data = result.data, error = result.error) }
            }
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<MemesViewModel, MemesState>

    companion object : MavericksViewModelFactory<MemesViewModel, MemesState> by hiltMavericksViewModelFactory()
}
