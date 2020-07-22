package com.stevechalker.shoppingapp.data.dagger

import com.stevechalker.shoppingapp.data.remote.ManagerSpecialsAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun providesRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/Swiftly-Systems/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()

    @Provides
    @Singleton
    fun providesOkhttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun providesManagerSpecialsAPI(retrofit: Retrofit): ManagerSpecialsAPI = retrofit.create(
        ManagerSpecialsAPI::class.java
    )
}