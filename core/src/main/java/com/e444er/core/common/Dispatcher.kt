package com.e444er.core.common

import kotlinx.coroutines.CoroutineDispatcher

data class Dispatcher(
    val io: CoroutineDispatcher,
    val main: CoroutineDispatcher,
    val default: CoroutineDispatcher,
)