package com.flickr.recent.data.entitiy

data class PhotoResponse(
    val photos: Photos?,
    val stat: String?,
    val code: Int?,
    val message: String?
)