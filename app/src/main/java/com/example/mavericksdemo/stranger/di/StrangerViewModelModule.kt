package com.example.mavericksdemo.stranger.di

import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.MavericksViewModelComponent
import com.airbnb.mvrx.hilt.ViewModelKey
import com.example.mavericksdemo.stranger.Repository
import com.example.mavericksdemo.stranger.StrangerFragment
import com.example.mavericksdemo.stranger.StrangerViewModel
import com.example.mavericksdemo.stranger.StrangerViewRenderer
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(MavericksViewModelComponent::class)
interface StrangerViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StrangerViewModel::class)
    fun strangerViewModelFactory(
        factory: StrangerViewModel.Factory
    ): AssistedViewModelFactory<*, *>
}
