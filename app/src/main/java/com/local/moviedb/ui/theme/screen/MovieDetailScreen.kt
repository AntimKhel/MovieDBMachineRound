package com.local.moviedb.ui.theme.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.local.moviedb.viewmodel.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    movieId: Long,
    viewModel: MovieDetailViewModel,
    onBackPress: () -> Unit
) {
    // LoadingView

    LaunchedEffect(key1 = Unit) {
        viewModel.getMovieDetail(movieId)
    }

    Scaffold(
        topBar = TopAppBar(
            navigationIcon = onBackPress
        ) {
            // Composable
        }
    ) {
        AnimatedVisibility(visible = viewModel.isLoading.value) {
            Column(
                Modifier.fillMaxSize()
            ) {
                // set viewModel.movie.value
                Row {
                    //MoviePoster Composable
                    Column {
                        //ReleaseDate Composable
                        //Rating Composable
                        //Popularity Composable
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))

                Column {
                    Text(text = "Overview")
                    //Overview Composable
                }
            }
        }
    }

}