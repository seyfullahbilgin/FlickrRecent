package com.flickr.recent.di.component

import android.app.Application
import com.flickr.recent.di.module.ActivityBindingModule
import com.flickr.recent.di.module.AppModule
import com.flickr.recent.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}

