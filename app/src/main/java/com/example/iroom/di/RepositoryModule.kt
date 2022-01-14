package com.example.iroom.di

import com.example.iroom.model.repository.*
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun authRepo(authRepoImp: AuthRepoImp): AuthRepo

    @Binds
    abstract fun cityRepo(cityRepoImp: CityRepoImpl): CityRepo

    @Binds
    abstract fun apartmentRepo(apartmentRepoImpl: ApartmentRepoIml): ApartmentRepo

    @Binds
    abstract fun orderRepo(orderRepoImpl: OrderRepoImpl): OrderRepo

    @Binds
    abstract fun notificationRepo(notificationRepo: NotificationRepoImpl): NotificationRepo
}