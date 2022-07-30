package com.local.moviedb.ui.theme.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import com.ang.acb.movienight.ui.common.MovieItem
import com.local.moviedb.viewmodel.MovieViewModel

@Composable
fun MovieListScreen(
    viewModel: MovieViewModel,
    onMovieClick: (Long) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = "Discover Poplar Movies")
            }
        }
    ) {
        val lazyPagingItems = viewModel.getPopularMoVie(1).collectAsLazyPagingItems()

        LazyColumn {
            items(lazyPagingItems) { item ->
                if (item != null) {
                    MovieItem(
                        movie = item,
                        onMovieClick = { onMovieClick(it) }
                    )
                }
            }

            lazyPagingItems.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item {
                            // Loading View
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item {
                            // Loading View
                        }
                    }

                    loadState.refresh is LoadState.Error -> {
                        val state = lazyPagingItems.loadState.refresh as LoadState.Error
                        item {
                          // Loading Error View
                        }
                    }

                    loadState.append is LoadState.Error -> {
                        val state = lazyPagingItems.loadState.append as LoadState.Error
                        item {
                            // Loading Error View
                        }
                    }
                }
            }
        }
    }
}