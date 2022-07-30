package com.local.moviedb.network

import com.local.moviedb.network.response.Movie
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val remoteMovieDataSource: RemoteMovieDataSource
): MovieRepoInterface {
    override suspend fun getPopularMovies(page: Int): Movies {
        return remoteMovieDataSource.getPopularMovies(page)
    }

    override suspend fun getMovieDetail(movieId: Long): Movie {
        return remoteMovieDataSource.getMovieDetail(movieId = movieId)
    }
}
