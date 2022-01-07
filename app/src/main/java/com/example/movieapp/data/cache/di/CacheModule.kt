package com.example.movieapp.data.cache.di

import androidx.room.Room
import com.example.movieapp.data.cache.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val cacheModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "moviedb.db"
        ).fallbackToDestructiveMigration().build()
    }
}