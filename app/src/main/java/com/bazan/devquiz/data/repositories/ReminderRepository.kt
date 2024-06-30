package com.bazan.devquiz.data.repositories

import com.bazan.devquiz.data.database.dao.ReminderDao
import com.bazan.devquiz.data.database.entities.ReminderEntity
import javax.inject.Inject

class ReminderRepository @Inject constructor(
    private val reminderDao: ReminderDao
) {
    suspend fun getAllReminders(): List<ReminderEntity> {
        return reminderDao.getAllReminders()
    }

    suspend fun insertReminder(reminder: ReminderEntity) {
        reminderDao.insert(reminder)
    }
}