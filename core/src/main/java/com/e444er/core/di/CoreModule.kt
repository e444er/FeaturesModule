package com.e444er.core.di

import com.e444er.core.common.Dispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    @Provides
    fun provideDispatchers(): Dispatcher = Dispatcher(
        io = Dispatchers.IO,
        main = Dispatchers.Main,
        default = Dispatchers.Default,
    )
}