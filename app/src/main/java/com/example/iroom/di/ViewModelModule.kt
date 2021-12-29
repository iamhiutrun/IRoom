package com.example.iroom.di
import androidx.lifecycle.ViewModelProvider
import com.example.iroom.viewmodel.authen.LoginViewModel
import com.example.iroom.viewmodel.authen.RegisterViewModel
import com.example.iroom.viewmodel.common.BaseViewModel
import com.example.iroom.viewmodel.common.ViewModelFactory
import com.example.iroom.viewmodel.common.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun loginViewModel(loginViewModel: LoginViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    internal abstract fun registerViewModel(registerViewModel: RegisterViewModel): BaseViewModel
}