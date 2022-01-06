package com.example.movieapp

import android.app.Application
import com.example.movieapp.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //initTheme()
        initKoin()
    }

    private fun initKoin() {

        //initialize koin
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MovieApplication)
            modules(listOf(domainModule))
        }
    }
}