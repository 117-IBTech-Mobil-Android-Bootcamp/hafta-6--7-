package com.patikadev.mvvmsample.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.patikadev.mvvmsample.ui.filmlist.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDB : RoomDatabase() {

    abstract fun moviesDao() : MovieDAO

}