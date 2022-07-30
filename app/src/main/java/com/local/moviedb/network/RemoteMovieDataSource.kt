package com.local.moviedb.network

import com.local.moviedb.network.response.Movie
import javax.inject.Inject

class RemoteMovieDataSource @Inject constructor(
    private val movieService: MovieService
) {

    suspend fun getPopularMovies(page: Int): Movies {
        return movieService.getPopularMovies(page).asMovies()
    }

    suspend fun getMovieDetail(movieId: Long): Movie {
        return movieService.getAllMovieDetails(movieId)
    }
}