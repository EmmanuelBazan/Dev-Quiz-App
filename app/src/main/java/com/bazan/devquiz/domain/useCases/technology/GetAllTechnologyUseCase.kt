package com.bazan.devquiz.domain.useCases.technology

import com.bazan.devquiz.data.database.entities.TechnologyEntity
import com.bazan.devquiz.data.repositories.TechnologyRepository
import javax.inject.Inject

class GetAllTechnologyUseCase @Inject constructor(
    private val technologyRepository: TechnologyRepository
) {
    suspend operator fun invoke(): List<TechnologyEntity> {
        return technologyRepository.getAllTechnologies()
    }
}