package com.example.movieapp.data.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.data.database.entity.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    /*Data Access Objects*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movie: List<Movie>)

    @Query("SELECT *FROM movie_table")
    fun getMovies(): Flow<List<Movie>>
}
