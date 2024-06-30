package com.bazan.devquiz.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bazan.devquiz.data.database.dao.ReminderDao
import com.bazan.devquiz.data.database.entities.DifficultyEntity
import com.bazan.devquiz.data.database.entities.QuestionEntity
import com.bazan.devquiz.data.database.entities.ReminderEntity
import com.bazan.devquiz.data.database.entities.TechnologyEntity

@Database(
    entities = [DifficultyEntity::class, QuestionEntity::class, ReminderEntity::class, TechnologyEntity::class],
    version = 1
)
abstract class DevQuizDatabase : RoomDatabase() {
    abstract fun getReminderDao():ReminderDao
}