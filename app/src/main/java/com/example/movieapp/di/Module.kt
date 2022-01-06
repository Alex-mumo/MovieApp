package com.example.movieapp.di

import com.example.movieapp.BuildConfig
import com.example.movieapp.data.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Module {

    private fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else OkHttpClient
        .Builder()
        .build()

    private fun provideRetrofit() : Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(ApiService.BASE_URL).build()

    private fun provideApiService(retrofit: Retrofit) = retrofit.
    create(ApiService::class.java)

}