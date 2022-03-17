package com.example.movieapp.data.data.cache.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.cache.database.entity.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movie: List<Movie>)

    @Query("SELECT * FROM movie_table WHERE category=:category")
    fun fetchMovies(category: String): Flow<List<Movie>>

    @Query("DELETE FROM movie_table WHERE category=:category")
    suspend fun deleteMovie(category: String)
}
