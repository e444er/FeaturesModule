package com.e444er.remote.api

import com.e444er.remote.dto.MovieApiDto
import retrofit2.http.GET

interface ApiService {
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): MovieApiDto
}