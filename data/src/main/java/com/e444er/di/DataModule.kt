package com.e444er.di

import com.e444er.HomeRepositoryImpl
import com.e444er.core.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository

}
