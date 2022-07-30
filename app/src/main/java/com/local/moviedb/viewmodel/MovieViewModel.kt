package com.local.moviedb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.local.moviedb.network.MovieRepoInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepoInterface
) : ViewModel() {

    fun getPopularMoVie(page: Int): Movies {
        return viewModelScope.launch {
            movieRepository.getPopularMovies(page)
        }

        // Comvert to Paging
    }
}