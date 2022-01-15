package com.example.iroom.di

import com.example.iroom.view.customer.CustomerActivity
import com.example.iroom.view.authen.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): CustomerActivity

    @ContributesAndroidInjector
    abstract fun contributeAuthenActivity(): AuthActivity
}