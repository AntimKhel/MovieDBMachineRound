package com.local.moviedb.ui.theme.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.insets.ProvideWindowInsets
import com.local.moviedb.navigation.NavScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()


    ProvideWindowInsets {
        NavHost(navController = navController, startDestination = NavScreen.Home.route) {
            composable(
                route = NavScreen.Home.route,
                arguments = emptyList()
            ) {
                MovieListScreen(
                    viewModel = hiltViewModel()
                ) {
                    navController.navigate("${NavScreen.MovieDetails.route}/$it")
                }
            }
            composable(
                route = NavScreen.MovieDetails.routeWithArg,
                arguments = listOf(
                    navArgument(NavScreen.MovieDetails.arg) { type = NavType.LongType }
                )
            ) { backStackEntry ->

                val movieId =
                    backStackEntry.arguments?.getLong(NavScreen.MovieDetails.arg)
                        ?: return@composable

                MovieDetailScreen(
                    movieId = movieId,
                    viewModel = hiltViewModel()
                ) {
                    navController.navigateUp()
                }
            }
        }
    }
}