package com.example.iroom.di

import com.example.iroom.model.repository.*
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun authRepo(authRepoImp: AuthRepoImp): AuthenRepo

    @Binds
    abstract fun cityRepo(cityRepoImp: CityRepoImpl): CityRepo

    @Binds
    abstract fun apartmentRepo(apartmentRepoImpl: ApartmentRepoIml): ApartmentRepo
}