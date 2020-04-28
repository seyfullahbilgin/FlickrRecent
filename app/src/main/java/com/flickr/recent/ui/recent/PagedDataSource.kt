package com.flickr.recent.ui.recent

import androidx.paging.PageKeyedDataSource
import com.flickr.recent.data.Result
import com.flickr.recent.data.entitiy.Photo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


class PagedDataSource
constructor(private val repository: RecentRepository, private val coroutineScope: CoroutineScope) :
    PageKeyedDataSource<Int, Photo>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Photo>
    ) {

        coroutineScope.launch {
            val result = repository.getRecent(
                FIRST_PAGE,
                PER_PAGE
            )
            when (result) {
                is Result.Success -> {
                    callback.onResult(result.data, null, FIRST_PAGE)
                }
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Photo>
    ) {

        coroutineScope.launch {
            val result = repository.getRecent(
                params.key,
                PER_PAGE
            )
            when (result) {
                is Result.Success -> {
                    callback.onResult(result.data, params.key - 1)
                }
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Photo>
    ) {
        coroutineScope.launch {
            val result = repository.getRecent(
                params.key,
                PER_PAGE
            )
            when (result) {
                is Result.Success -> {
                    callback.onResult(result.data, params.key + 1)
                }
            }
        }
    }

    override fun invalidate() {
        super.invalidate()
        coroutineScope.cancel()
    }


    companion object {
        const val FIRST_PAGE = 1
        const val PER_PAGE = 20
    }
}
