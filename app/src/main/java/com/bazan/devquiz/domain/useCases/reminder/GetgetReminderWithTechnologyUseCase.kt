package com.bazan.devquiz.domain.useCases.reminder

import com.bazan.devquiz.data.database.relations.ReminderFull
import com.bazan.devquiz.data.repositories.ReminderRepository
import javax.inject.Inject

class GetgetReminderWithTechnologyUseCase @Inject constructor(
    private val reminderRepository: ReminderRepository
) {
    suspend operator fun invoke(id: Int): ReminderFull {
        return reminderRepository.getReminderWithTechnologyById(id)
    }
}