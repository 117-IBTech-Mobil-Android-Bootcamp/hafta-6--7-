package com.patikadev.mvvmsample.ui.filmlist

import androidx.lifecycle.*
import com.patikadev.mvvmsample.Result
import com.patikadev.mvvmsample.repository.FilmRepository
import com.patikadev.mvvmsample.ui.filmlist.model.Movie
import com.patikadev.mvvmsample.ui.filmlist.model.MovieListViewStateModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MovieListViewModel(private val filmRepository: FilmRepository) : ViewModel() {


    val onMoviesFetched = MutableLiveData<MovieListViewStateModel>()
    val onIsFavorited = MutableLiveData<Boolean>()
    val onError = MutableLiveData<Unit>()

    fun prepareMovies() {

        viewModelScope.launch {

            val movieListResponseFetchedFromDB = filmRepository.getListAsync()
            onMoviesFetched.value = MovieListViewStateModel(movieListResponseFetchedFromDB)

            delay(3 * 1000)

            val remoteResponse = filmRepository.getAllMoviesFromRemote()
            when(remoteResponse){
                is Result.Success -> {
                    onMoviesFetched.value = MovieListViewStateModel(remoteResponse.data!!)
                }
                is Result.Error -> onError.value = Unit
            }

        }


    }
}