package com.flickr.recent.ui.recent

import androidx.lifecycle.*
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.flickr.recent.data.entitiy.Photo
import javax.inject.Inject


class RecentViewModel
@Inject
constructor(private val repository: RecentRepository) : ViewModel() {

    private var recent: LiveData<PagedList<Photo>>? = null

    private var config = PagedList.Config.Builder()
        .setPageSize(PagedDataSource.PER_PAGE)
        .setInitialLoadSizeHint(PagedDataSource.PER_PAGE)
        .setEnablePlaceholders(false)
        .build()


    private fun initializedPagedListBuilder(config: PagedList.Config): LivePagedListBuilder<Int, Photo> {

        val dataSourceFactory = object : DataSource.Factory<Int, Photo>() {
            override fun create(): DataSource<Int, Photo> {
                return PagedDataSource(
                    repository,
                    viewModelScope
                )
            }
        }

        return LivePagedListBuilder(
            dataSourceFactory,
            config
        )
    }


    fun getRecent(isCached: Boolean = true): LiveData<PagedList<Photo>>? {

        if (isCached && recent != null)
            return recent

        recent = initializedPagedListBuilder(config).build()
        return recent
    }
}


