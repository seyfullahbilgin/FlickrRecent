package com.flickr.recent.data.remote.api


import com.flickr.recent.data.entitiy.PhotoResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.*


interface FlickrService {

    companion object {
        const val FLICKR_API_URL = "https://www.flickr.com/"
    }


    @GET("services/rest/?method=flickr.photos.getRecent&nojsoncallback=1&format=json")
    fun getRecent(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Deferred<PhotoResponse>
}

