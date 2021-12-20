package com.example.iroom.di
import androidx.lifecycle.ViewModelProvider
import com.example.iroom.viewmodel.common.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @ViewModelKey(HomeViewModel::class)
//    internal abstract fun homeViewModel(homeViewModel: HomeViewModel): com.example.iroom.viewmodel.common.BaseViewModel
}