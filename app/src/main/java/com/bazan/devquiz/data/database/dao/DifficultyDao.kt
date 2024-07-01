package com.bazan.devquiz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.bazan.devquiz.data.database.entities.DifficultyEntity

@Dao
interface DifficultyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(difficulty:DifficultyEntity)
}