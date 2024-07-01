package com.bazan.devquiz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.bazan.devquiz.data.database.entities.ReminderEntity
import com.bazan.devquiz.data.database.entities.TechnologyEntity
import com.bazan.devquiz.data.database.relations.ReminderFull
import dagger.Provides

@Dao
interface TechnologyDao {
    @Query("SELECT * FROM technology_table")
    suspend fun getAllTechnologies():List<TechnologyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(technology:TechnologyEntity)

    @Transaction
    @Query("SELECT * FROM technology_table WHERE id = :id")
    suspend fun getTechnologyById(id: Int): TechnologyEntity
}