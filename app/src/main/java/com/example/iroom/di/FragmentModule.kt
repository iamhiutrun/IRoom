package com.example.iroom.di
import com.example.iroom.view.authen.LoginFragment
import com.example.iroom.view.profile.ProfileFragment
import com.example.iroom.view.authen.RegisterFragment
import com.example.iroom.view.authen.SignupFragment
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

}
