package com.bazan.devquiz.domain.useCases.difficulty

import com.bazan.devquiz.data.database.entities.DifficultyEntity
import com.bazan.devquiz.data.repositories.DifficultyRepository
import javax.inject.Inject

class GetAllDiffultyUseCase @Inject constructor(
    private val difficultyRepository: DifficultyRepository
) {
    suspend operator fun invoke(): List<DifficultyEntity> {
        return difficultyRepository.getAllDiffulty()
    }
}