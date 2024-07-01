package com.bazan.devquiz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bazan.devquiz.data.database.entities.ReminderEntity
import com.bazan.devquiz.data.database.entities.TechnologyEntity
import dagger.Provides

@Dao
interface TechnologyDao {
    @Query("SELECT * FROM technology_table")
    suspend fun getAllTechnologies():List<TechnologyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(technology:TechnologyEntity)
}