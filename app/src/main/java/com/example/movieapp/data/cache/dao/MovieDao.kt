package com.example.movieapp.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.cache.models.MoviesEntity
import com.example.movieapp.domain.model.Movies


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveMovies(moviesEntity : List<MoviesEntity>)

    @Query("SELECT * FROM movie_table WHERE category=:category")
    fun getMovies(category: String): List<MoviesEntity>

    @Query("SELECT * FROM movie_table WHERE id=:id")
    fun getMoviesById(id: String): List<MoviesEntity>

}
