package com.flickr.recent.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module


@Module(includes = [RetrofitModule::class, ViewModelModule::class])
abstract class AppModule {

    @Binds
    internal abstract fun bindContext(application: Application): Context
}
