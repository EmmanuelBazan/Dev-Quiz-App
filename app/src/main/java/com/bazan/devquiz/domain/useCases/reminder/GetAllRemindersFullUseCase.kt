package com.bazan.devquiz.domain.useCases.reminder

import com.bazan.devquiz.data.database.relations.ReminderFull
import com.bazan.devquiz.data.repositories.ReminderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllRemindersFullUseCase @Inject constructor(
    private val repository: ReminderRepository
) {
    suspend operator fun invoke(): List<ReminderFull> = withContext(Dispatchers.IO) {
        repository.getAllRemindersFull()
    }
}