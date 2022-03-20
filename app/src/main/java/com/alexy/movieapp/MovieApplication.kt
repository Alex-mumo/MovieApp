package com.alexy.movieapp

import android.app.Application
import com.alexy.movieapp.data.cache.di.cacheModule
import com.alexy.movieapp.data.network.di.networkModule
import com.alexy.movieapp.data.repository.di.repositoryModule
import com.alexy.movieapp.domain.di.domainModule
import com.alexy.movieapp.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }

    private fun initKoin() {
        val modules = listOf(networkModule, domainModule, presentationModule, cacheModule, repositoryModule)
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MovieApplication)
            modules(modules)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}