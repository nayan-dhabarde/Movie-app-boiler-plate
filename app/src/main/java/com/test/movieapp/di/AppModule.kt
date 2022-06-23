package com.test.movieapp.di

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import com.test.movieapp.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module()
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRetrofitService(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com")
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(OkHttpProfilerInterceptor())
            .build()
    }

}