package com.bazan.devquiz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bazan.devquiz.data.database.entities.DifficultyEntity
import com.bazan.devquiz.data.database.entities.TechnologyEntity

@Dao
interface DifficultyDao {
    @Query("SELECT * FROM difficulty_table")
    suspend fun getAllDifficulty():List<DifficultyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(difficulty:DifficultyEntity)
}