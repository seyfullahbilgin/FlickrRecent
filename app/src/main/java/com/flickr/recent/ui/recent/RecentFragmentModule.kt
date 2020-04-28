package com.flickr.recent.ui.recent

import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.Module
import dagger.Provides

@Module
class RecentFragmentModule {

    @Provides
    internal fun provideStaggeredGridLayoutManager() =
        StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
}
