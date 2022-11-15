package com.e444er.mapper

import com.e444er.core.model.Movie
import com.e444er.model.MovieData

fun MovieData.toCoreModel() =
    Movie(id, title, posterPath)
