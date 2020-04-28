package com.flickr.recent.data.entitiy

data class Photo(
    val farm: Int?,
    val id: String?,
    val isfamily: Int?,
    val isfriend: Int?,
    val ispublic: Int?,
    val owner: String?,
    val secret: String?,
    val server: String?,
    val title: String?
) {
    
    private val url: String
        get() = "https://farm${farm}.staticflickr.com/${server}/${id}_${secret}"

    val thumbnailUrl: String
        get() = "${url}_m.jpg"

    val bigPhotoUrl: String
        get() = "${url}_b.jpg"
}