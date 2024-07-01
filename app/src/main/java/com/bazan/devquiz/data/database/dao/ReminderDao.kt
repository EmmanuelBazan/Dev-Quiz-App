package com.bazan.devquiz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.bazan.devquiz.data.database.entities.ReminderEntity
import com.bazan.devquiz.data.database.relations.ReminderFull

@Dao
interface ReminderDao {
    @Query("SELECT * FROM reminders_table")
    suspend fun getAllReminders():List<ReminderEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reminder:ReminderEntity)

    @Transaction
    @Query("SELECT * FROM reminders_table WHERE id = :id")
    suspend fun getReminderWithTechnologyById(id: Int): ReminderFull

    @Transaction
    @Query("SELECT * FROM reminders_table")
    fun getAllRemindersFull(): List<ReminderFull>
}