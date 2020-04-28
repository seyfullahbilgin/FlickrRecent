package com.flickr.recent.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flickr.recent.common.ViewModelFactory
import com.flickr.recent.di.key.ViewModelKey
import com.flickr.recent.ui.recent.RecentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RecentViewModel::class)
    internal abstract fun bindRecentViewModel(viewModel: RecentViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelProviderFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
