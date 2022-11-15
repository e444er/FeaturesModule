package com.e444er.core.repository

import com.e444er.core.model.Movie

interface HomeRepository {
    suspend fun getTopRatedMovies(): List<Movie>
}
