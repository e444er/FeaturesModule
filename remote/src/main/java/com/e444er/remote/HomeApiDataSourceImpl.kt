package com.e444er.remote

import com.e444er.data.HomeApiDataSource
import com.e444er.model.MovieData
import com.e444er.remote.api.ApiService
import com.e444er.remote.mapper.toDataModel
import javax.inject.Inject

class HomeApiDataSourceImpl @Inject constructor(
    private val service: ApiService
) : HomeApiDataSource {

    override suspend fun getTopRatedMovies(): List<MovieData> {
        return service.getTopRatedMovies()
            .results.map { it.toDataModel() }
    }
}