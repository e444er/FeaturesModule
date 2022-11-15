package com.e444er.remote.di

import com.e444er.data.HomeApiDataSource
import com.e444er.remote.HomeApiDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RemoteModule {

    @Binds
    fun bindHomeRemoteSource(impl: HomeApiDataSourceImpl): HomeApiDataSource

}
