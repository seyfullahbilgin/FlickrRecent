package com.flickr.recent.di.module

import com.flickr.recent.ui.photo.PhotoFragment
import com.flickr.recent.ui.recent.RecentFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityFragmentModule {

    @ContributesAndroidInjector
    internal abstract fun recentFragment(): RecentFragment

    @ContributesAndroidInjector
    internal abstract fun photoFragment(): PhotoFragment
}
