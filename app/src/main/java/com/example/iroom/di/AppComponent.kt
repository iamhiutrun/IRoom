package com.example.iroom.di

import com.example.iroom.IRoomApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        ActivityModule::class,
        FragmentModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
    ]
)
interface AppComponent: AndroidInjector<IRoomApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: IRoomApplication): AppComponent
    }


}