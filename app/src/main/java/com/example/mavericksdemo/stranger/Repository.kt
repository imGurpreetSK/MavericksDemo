package com.example.mavericksdemo.stranger

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.delayEach
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class Repository @Inject constructor() {

    suspend fun getNames() : List<String> {
        delay(1000)
        return listOf("One", "Two", "Three")
    }

    suspend fun getNamesFlow() : Flow<String> {
        return flowOf("1", "2", "3")
            .onEach { delay(1000) }
    }
}
