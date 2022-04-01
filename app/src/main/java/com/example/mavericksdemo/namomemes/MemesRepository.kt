package com.example.mavericksdemo.namomemes

import com.example.mavericksdemo.base.DispatcherProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.GET
import javax.inject.Inject

interface MemesRepository {
    suspend fun fetchMemes(): FetchEvent<List<Meme>>
}

class MemesRepositoryImpl @Inject constructor(
    private val memesService: MemesService,
    private val dispatcherProvider: DispatcherProvider
) : MemesRepository {

    override suspend fun fetchMemes(): FetchEvent<List<Meme>> {
        return withContext(dispatcherProvider.io) {
            try {
                val memes = memesService.getMemes()
                FetchEvent(FetchStatus.SUCCESSFUL, memes)
            } catch (e: Exception) {
                e.printStackTrace()
                FetchEvent(FetchStatus.FAILED, emptyList(), ApplicationError(e.message ?: ""))
            }
        }
    }
}

interface MemesService {

    @GET("memes/1")
    suspend fun getMemes(): List<Meme>
}
