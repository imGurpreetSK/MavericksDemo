package com.example.mavericksdemo.namomemes

data class ApplicationError(
    val message: String,
    val throwable: Throwable? = null
)
