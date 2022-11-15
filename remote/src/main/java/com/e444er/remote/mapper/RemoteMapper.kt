package com.e444er.remote.mapper

import com.e444er.model.MovieData
import com.e444er.remote.dto.MovieResultDto

fun MovieResultDto.toDataModel() =
    MovieData(id, title, posterPath)
