package com.local.moviedb.di

import com.local.moviedb.network.MovieRepoInterface
import com.local.moviedb.network.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieGateway(
        movieRepository: MovieRepository
    ): MovieRepoInterface = movieRepository
}