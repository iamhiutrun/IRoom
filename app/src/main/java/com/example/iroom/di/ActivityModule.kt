package com.example.iroom.di

import com.example.iroom.MainActivity
import com.example.iroom.view.authen.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeAuthenActivity(): AuthActivity
}