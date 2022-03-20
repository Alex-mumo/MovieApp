package com.example.movieapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

@HiltAndroidApp
class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MovieApplication)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}