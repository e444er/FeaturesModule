package com.e444er.remote.di

import android.content.Context
import com.e444er.remote.api.ApiService
import com.e444er.remote.common.ApiHelper.OKHTTP_MAX_CACHE_SIZE
import com.e444er.remote.common.ApiKeyInterceptor
import com.e444er.remote.common.CacheInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
open class ApiModule {

    protected open val baseUrl = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val key = "271236134afbbdcd24c3caaaab027824"

        return OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor(key))
            .addNetworkInterceptor(CacheInterceptor())
            .cache(provideCache(context))
            .build()
    }



    private fun provideCache(context: Context): Cache? {
        var cache: Cache? = null

        try {
            cache = Cache(
                File(context.cacheDir, "http-cache"),
                OKHTTP_MAX_CACHE_SIZE
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return cache
    }
}
