package com.example.movieapp

import android.app.Application
import org.koin.core.context.startKoin

/*application class*/
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf())

        }
    }
}