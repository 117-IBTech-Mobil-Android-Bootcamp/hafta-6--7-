package com.patikadev.mvvmsample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.patikadev.mvvmsample.ui.filmlist.model.Movie

@Dao
interface MovieDAO {

    /*
    *bizim case'imize göre conflict oldugunda, conflict olan row'u
    * yeni gelen row ile replace edecek(değişticek/update edecek)
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie : Movie)

    @Query("SELECT * FROM MOVIES ")
    suspend fun  fetchMovies() : List<Movie>
}