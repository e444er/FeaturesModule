package com.e444er.core.usecase.home

import com.e444er.core.common.Dispatcher
import com.e444er.core.model.Movie
import com.e444er.core.repository.HomeRepository
import com.e444er.core.usecase.base.BaseSuspendableUseCase
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(
    private val repository: HomeRepository,
    private val dispatcher: Dispatcher
) : BaseSuspendableUseCase<Unit, List<Movie>>() {

    override suspend fun execute(input: Unit?): List<Movie> = withContext(dispatcher.io) {
        repository.getTopRatedMovies()
    }
}