package com.patikadev.mvvmsample.ui.filmlist.model

import com.patikadev.mvvmsample.network.response.MovieListResponse

data class MovieListViewStateModel(val response: MovieListResponse) {

    fun getResults(): String = if (response.totalResults != 0) "total count ${response.totalResults}" else ""

    fun getTotalPage(): String = if (response.totalPage != 0) "total page ${response.totalPage}" else ""

    fun getList(): List<Movie> = response.movies

}
