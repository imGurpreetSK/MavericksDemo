package com.example.mavericksdemo.namomemes.di

import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.MavericksViewModelComponent
import com.airbnb.mvrx.hilt.ViewModelKey
import com.example.mavericksdemo.namomemes.MemesRepository
import com.example.mavericksdemo.namomemes.MemesRepositoryImpl
import com.example.mavericksdemo.namomemes.MemesService
import com.example.mavericksdemo.namomemes.MemesViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

@Module
@InstallIn(MavericksViewModelComponent::class)
interface MemesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MemesViewModel::class)
    fun memesViewModelFactory(factory: MemesViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    fun memesRepository(repository: MemesRepositoryImpl): MemesRepository

    companion object {

        @JvmStatic
        @Provides
        fun memesService(retrofit: Retrofit): MemesService = retrofit.create(MemesService::class.java)
    }
}
