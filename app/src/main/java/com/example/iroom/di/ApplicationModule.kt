package com.example.iroom.di
import android.app.Application
import com.example.iroom.IRoomApplication
import dagger.Binds
import dagger.Module

@Module
internal abstract class ApplicationModule {

    @Binds
    abstract fun application(application: IRoomApplication): Application
}