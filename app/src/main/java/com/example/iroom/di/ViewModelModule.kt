package com.example.iroom.di

import androidx.lifecycle.ViewModelProvider
import com.example.iroom.viewmodel.authen.LoginViewModel
import com.example.iroom.viewmodel.collection.CollectionViewModel
import com.example.iroom.viewmodel.authen.RegisterViewModel
import com.example.iroom.viewmodel.common.BaseViewModel
import com.example.iroom.viewmodel.common.ViewModelFactory
import com.example.iroom.viewmodel.common.ViewModelKey
import com.example.iroom.viewmodel.home.ApartmentViewModel
import com.example.iroom.viewmodel.home.HomeViewModel
import com.example.iroom.viewmodel.home.SearchViewModel
import com.example.iroom.viewmodel.notification.NotificationViewModel
import com.example.iroom.viewmodel.order.OrderViewModel
import com.example.iroom.viewmodel.order.PaymentViewModel
import com.example.iroom.viewmodel.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

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
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(homeViewModel: HomeViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    internal abstract fun searchViewModel(searchViewModel: SearchViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CollectionViewModel::class)
    internal abstract fun collectionViewModel(collectionViewModel: CollectionViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    internal abstract fun registerViewModel(registerViewModel: RegisterViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    internal abstract fun profileViewModel(profileViewModel: ProfileViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ApartmentViewModel::class)
    internal abstract fun apartmentViewModel(apartmentViewModel: ApartmentViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OrderViewModel::class)
    internal abstract fun orderViewModel(orderViewModel: OrderViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PaymentViewModel::class)
    internal abstract fun paymentViewModel(paymentViewModel: PaymentViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotificationViewModel::class)
    internal abstract fun notificationViewModel(notificationViewModel: NotificationViewModel): BaseViewModel
}