package com.patikadev.mvvmsample.repository

import com.patikadev.mvvmsample.Result
import com.patikadev.mvvmsample.db.MovieDAO
import com.patikadev.mvvmsample.network.MovieAPI
import com.patikadev.mvvmsample.network.response.MovieListResponse
import com.patikadev.mvvmsample.ui.filmlist.model.Movie
import com.patikadev.mvvmsample.util.API_KEY

class FilmRepository(private val api: MovieAPI, private val movieDao: MovieDAO) {

    suspend fun getAllMoviesFromRemote(): Result<MovieListResponse> {


        val tapRatedMoviesResponse = api.getTopRatedMovies(API_KEY)


        return if (tapRatedMoviesResponse != null) {
            tapRatedMoviesResponse.movies.forEach { insertDataAsync(movie = it) }
            Result.Success(tapRatedMoviesResponse)
        }
        else Result.Error(
            "bir hata meydana geldi"
        )
    }


    suspend fun insertDataAsync(movie: Movie) = movieDao.insertMovie(movie)

    suspend fun getListAsync(): MovieListResponse {
        val movieList = movieDao.fetchMovies()
        return MovieListResponse(0, 0, 0, movieList)
    }
}