package com.example.movieapp.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.cache.models.MoviesEntity
import java.util.concurrent.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<MoviesEntity>)

    /*@Query("SELECT * FROM movie_table WHERE category=:category")
    //fun getMovies(category: String): Flow<List<MoviesEntity>>

    @Query("SELECT * FROM movie_table WHERE id=:id")
    fun getMoviesById(id: String): Flow<MoviesEntity>
*/
}