package com.bazan.devquiz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bazan.devquiz.data.database.entities.TechnologyEntity
import dagger.Provides

@Dao
interface TechnologyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(technology:TechnologyEntity)
}