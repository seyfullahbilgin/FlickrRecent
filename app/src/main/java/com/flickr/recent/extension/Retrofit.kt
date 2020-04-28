package com.flickr.recent.extension

import retrofit2.Retrofit

inline fun <reified S> Retrofit.createService(): S {
    return create(S::class.java)
}