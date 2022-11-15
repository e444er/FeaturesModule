package com.e444er.data

import com.e444er.model.MovieData

interface HomeApiDataSource {

    suspend fun getTopRatedMovies(): List<MovieData>
}