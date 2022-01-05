package com.example.movieapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.logging.Logger

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initTheme()
        initKoin()
    }

    private fun initTheme() {

    }

    private fun initKoin() {
        //val modules =  listOf()
        startKoin {
            androidContext(this@MovieApplication)
        }
    }
}