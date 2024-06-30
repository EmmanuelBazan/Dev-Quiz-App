package com.bazan.devquiz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bazan.devquiz.data.database.entities.ReminderEntity

@Dao
interface ReminderDao {
    @Query("SELECT * FROM reminders_table")
    suspend fun getAllReminders():List<ReminderEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reminder:ReminderEntity)
}