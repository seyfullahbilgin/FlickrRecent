package com.flickr.recent.ui.recent

import com.flickr.recent.data.Result
import com.flickr.recent.data.entitiy.Photo
import com.flickr.recent.data.remote.Secret
import com.flickr.recent.data.remote.api.FlickrService
import javax.inject.Inject


class RecentRepository
@Inject
constructor() {

    @Inject
    lateinit var apiService: FlickrService

    suspend fun getRecent(page: Int, perPage: Int): Result<List<Photo>> {

        val response = apiService.getRecent(Secret.API_KEY, page, perPage).await()

        response.run {
            return if (stat == "ok")
                Result.Success(photos?.photo ?: emptyList())
            else
                Result.Error(Exception(message))
        }
    }
}