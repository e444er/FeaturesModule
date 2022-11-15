package com.e444er

import com.e444er.core.model.Movie
import com.e444er.core.repository.HomeRepository
import com.e444er.data.HomeApiDataSource
import com.e444er.mapper.toCoreModel
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remoteSource: HomeApiDataSource
) : HomeRepository {

    override suspend fun getTopRatedMovies(): List<Movie> {
        return remoteSource.getTopRatedMovies()
            .map { movieData -> movieData.toCoreModel() }
    }
}