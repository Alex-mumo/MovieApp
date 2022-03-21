package com.alexy.movieapp.data.repository.datasources

import androidx.lifecycle.MutableLiveData
import com.alexy.movieapp.data.cache.database.entity.Movie
import com.alexy.movieapp.data.data.cache.database.db.MovieDatabase
import com.alexy.movieapp.data.network.ApiService
import com.alexy.movieapp.data.repository.utils.Coroutines
import com.alexy.movieapp.data.repository.mapper.toDomain
import com.alexy.movieapp.data.repository.mapper.toEntity
import com.alexy.movieapp.domain.models.MovieShow
import com.alexy.movieapp.domain.repositories.MovieRepository
import com.alexy.movieapp.presentation.utils.Constants.POPULAR_MOVIE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl  constructor(
    private val movieDatabase: MovieDatabase,
    private val apiService: ApiService
): MovieRepository{

    private val _popularMovies = MutableLiveData<List<Movie>>()

    init {
        _popularMovies.observeForever {
            Coroutines.io { saveMovies(it) }
        }
    }
    override suspend fun fetchMovies(): Flow<List<MovieShow>> {
        val isCacheAvailable = movieDatabase.movieDao().isCacheAvailable(category = POPULAR_MOVIE) > 0
        return if (isCacheAvailable) {
            val cacheResponse = movieDatabase.movieDao().fetchMovies(category = POPULAR_MOVIE)
            cacheResponse.map { it.map { movieList -> movieList.toDomain() } }
        } else {
            val networkResponse = apiService.fetchMovies()
            _popularMovies.value = networkResponse.movies?.map { it.toEntity(category = POPULAR_MOVIE) }
            val cacheResponse = movieDatabase.movieDao().fetchMovies(category = POPULAR_MOVIE)
            cacheResponse.map { it.map { movieList -> movieList.toDomain() } }
        }
    }
    private suspend fun saveMovies(movie: List<Movie>) {
        movieDatabase.movieDao().saveMovies(movie)
    }
}
/*
java.lang.NullPointerException: it must not be null
at com.alexy.movieapp.data.repository.datasources.MovieRepositoryImpl$1$1.invokeSuspend(MovieRepositoryImpl.kt:23)
at com.alexy.movieapp.data.repository.datasources.MovieRepositoryImpl$1$1.invoke(Unknown Source:8)
at com.alexy.movieapp.data.repository.datasources.MovieRepositoryImpl$1$1.invoke(Unknown Source:2)
at com.alexy.movieapp.data.repository.utils.Coroutines$io$1.invokeSuspend(Coroutines.kt:15)
at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:106)
at kotlinx.coroutines.internal.LimitedDispatcher.run(LimitedDispatcher.kt:39)
at kotlinx.coroutines.scheduling.TaskImpl.run(Tasks.kt:95)
at kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:571)
at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.executeTask(CoroutineScheduler.kt:750)
at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.runWorker(CoroutineScheduler.kt:678)
at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:665)

2022-03-21 09:25:21.757 24793-24976/? E/AndroidRuntime: FATAL EXCEPTION: DefaultDispatcher-worker-1
    Process: com.example.movieapp, PID: 24793
    java.lang.NullPointerException: it must not be null
        at com.alexy.movieapp.data.repository.datasources.MovieRepositoryImpl$1$1.invokeSuspend(MovieRepositoryImpl.kt:25)
        at com.alexy.movieapp.data.repository.datasources.MovieRepositoryImpl$1$1.invoke(Unknown Source:8)
        at com.alexy.movieapp.data.repository.datasources.MovieRepositoryImpl$1$1.invoke(Unknown Source:2)
        at com.alexy.movieapp.data.repository.utils.Coroutines$io$1.invokeSuspend(Coroutines.kt:15)
        at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
        at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:106)
        at kotlinx.coroutines.internal.LimitedDispatcher.run(LimitedDispatcher.kt:39)
        at kotlinx.coroutines.scheduling.TaskImpl.run(Tasks.kt:95)
        at kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:571)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.executeTask(CoroutineScheduler.kt:750)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.runWorker(CoroutineScheduler.kt:678)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:665)
*/