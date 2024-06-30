package com.bazan.devquiz.domain.useCases.reminder

import com.bazan.devquiz.data.database.entities.ReminderEntity
import com.bazan.devquiz.data.repositories.ReminderRepository
import javax.inject.Inject

class GetAllRemindersUseCase @Inject constructor(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke(): List<ReminderEntity> {
        return repository.getAllReminders()
    }
}