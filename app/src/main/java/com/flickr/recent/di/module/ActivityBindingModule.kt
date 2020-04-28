package com.flickr.recent.di.module

import com.flickr.recent.di.scope.ActivityScoped
import com.flickr.recent.ui.main.MainActivity
import com.flickr.recent.ui.main.MainActivityModule
import com.flickr.recent.ui.recent.RecentFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            ActivityFragmentModule::class,
            RecentFragmentModule::class
        ]
    )

    internal abstract fun mainActivity(): MainActivity

}