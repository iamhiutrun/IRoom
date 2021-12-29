package com.example.iroom.di

import com.example.iroom.model.repository.AuthRepoImp
import com.example.iroom.model.repository.AuthenRepo
import com.example.iroom.model.repository.CityRepo
import com.example.iroom.model.repository.CityRepoImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun authRepo(authRepoImp: AuthRepoImp): AuthenRepo

    @Binds
    abstract fun cityRepo(cityRepoImp: CityRepoImpl): CityRepo
}