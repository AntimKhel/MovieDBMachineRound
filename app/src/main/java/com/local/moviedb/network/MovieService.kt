package com.local.moviedb.network

import com.local.moviedb.network.response.Movie
import com.local.moviedb.network.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MoviesResponse

    @GET("movie/{id}")
    suspend fun getAllMovieDetails(@Path("id") id: Long): Movie
}