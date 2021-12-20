//package com.example.iroom.di
//
//import AppDatabase
//import UserDAO
//import android.app.Application
//import androidx.room.Room
//import com.example.iroom.utils.Const
//import dagger.Module
//import dagger.Provides
//import javax.inject.Named
//import javax.inject.Singleton
//
//
//@Module
//class DatabaseModule {
//
//    @Provides
//    @Singleton
//    @Named("app_db")
//    fun database(application: Application) = Room.databaseBuilder(application, AppDatabase::class.java, Const.DATABASE_NAME).allowMainThreadQueries().build()
//
//    @Singleton
//    @Provides
//    fun userDao(@Named("app_db") database: AppDatabase): UserDAO = database.userDao()
//}