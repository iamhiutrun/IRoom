package com.example.iroom.di

import com.example.iroom.view.authen.LoginFragment
import com.example.iroom.view.authen.ProfileFragment
import com.example.iroom.view.authen.RegisterFragment
import com.example.iroom.view.authen.SignupFragment
import com.example.iroom.view.collection.CollectionFragment
import com.example.iroom.view.home.HomeFragment
import com.example.iroom.view.home.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributesSignupFragment(): SignupFragment

    @ContributesAndroidInjector
    abstract fun contributesRegisterFragment(): RegisterFragment

    @ContributesAndroidInjector
    abstract fun contributesProfileFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun contributesCollectionFragment(): CollectionFragment

}
