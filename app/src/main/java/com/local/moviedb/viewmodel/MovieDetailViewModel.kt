package com.local.moviedb.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.local.moviedb.network.MovieRepoInterface
import com.local.moviedb.network.response.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel@Inject constructor(
    private val movieRepository: MovieRepoInterface
) : ViewModel()  {
    var isLoading = mutableStateOf(false)
    var movie = mutableStateOf<Movie?>(null)

    fun getMovieDetail(movieId: Long): Boolean {
        viewModelScope.launch {
            movieRepository.getMovieDetail(movieId)

            // set isLoading  and movie
        }

        // When ApiResponse
        // Suucess - True
        // Error - False
    }
}