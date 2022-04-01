package com.example.mavericksdemo.namomemes

data class FetchEvent<T>(
    val fetchStatus: FetchStatus,
    val data: T,
    val error: ApplicationError? = null
)
