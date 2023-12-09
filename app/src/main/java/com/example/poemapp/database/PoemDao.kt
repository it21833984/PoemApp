package com.example.poemapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PoemDao {

    @Delete
    suspend fun delete(poem: poem)

    @Query("SELECT * FROM poem_table ORDER BY id ASC")
    fun getAllPoems():List<poem>

    @Insert
    suspend fun insert(poem: poem)


}