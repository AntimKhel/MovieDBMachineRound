package com.local.moviedb.network

import com.local.moviedb.network.response.Movie

interface MovieRepoInterface {
    suspend fun getPopularMovies(page: Int): Movies
    suspend fun getMovieDetail(movieId: Long): Movie
}