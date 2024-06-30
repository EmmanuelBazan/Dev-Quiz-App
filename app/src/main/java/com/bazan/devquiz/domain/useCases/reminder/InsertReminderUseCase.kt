package com.bazan.devquiz.domain.useCases.reminder

import com.bazan.devquiz.data.database.entities.ReminderEntity
import com.bazan.devquiz.data.repositories.ReminderRepository
import javax.inject.Inject

class InsertReminderUseCase @Inject constructor(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke(reminder: ReminderEntity) {
        repository.insertReminder(reminder)
    }
}