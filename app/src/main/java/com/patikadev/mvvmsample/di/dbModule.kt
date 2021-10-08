package com.patikadev.mvvmsample.di

import androidx.room.Room
import com.patikadev.mvvmsample.db.MovieDB
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val DATABASE_NAME = "DB"
val dbModule = module {

    // Room Database
    single { Room.databaseBuilder(androidContext(), MovieDB::class.java, DATABASE_NAME).build() }

    // MoviesDao
    single { get<MovieDB>().moviesDao() }
}