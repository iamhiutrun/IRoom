package com.example.iroom.di
import com.example.iroom.model.repository.AuthenRepo
import com.example.iroom.model.repository.AuthenRepoImp
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun authenRepo(authenRepoImp: AuthenRepoImp) : AuthenRepo
}