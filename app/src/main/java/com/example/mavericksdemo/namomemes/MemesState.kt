package com.example.mavericksdemo.namomemes

import com.airbnb.mvrx.MavericksState
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

data class MemesState(
    val status: FetchStatus = FetchStatus.IN_FLIGHT,
    val data: List<Meme> = emptyList(),
    val error: ApplicationError? = null
) : MavericksState

@JsonClass(generateAdapter = true)
data class Meme(
    @Json(name = "_id") val id: String,
    val url: String,
    val createdAt: Date
)
