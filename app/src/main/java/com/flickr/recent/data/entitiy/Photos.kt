package com.flickr.recent.data.entitiy

data class Photos(
    val page: Int?,
    val pages: Int?,
    val perpage: Int?,
    val photo: List<Photo>?,
    val total: Int?
)