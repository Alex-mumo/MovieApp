package com.example.dagger.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.dagger.model.RepositoryData

/*specifies data access methods*/
@Dao
interface AppDao {
    @Query("SELECT * FROM repositories")
    fun getAllRecords(): LiveData<List<RepositoryData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecord(repositoryData: RepositoryData)

    @Query("DELETE FROM repositories")
    fun deleteAllRecords()
}