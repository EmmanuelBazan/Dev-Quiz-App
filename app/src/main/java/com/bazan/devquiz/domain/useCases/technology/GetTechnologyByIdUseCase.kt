package com.bazan.devquiz.domain.useCases.technology

import com.bazan.devquiz.data.database.entities.TechnologyEntity
import com.bazan.devquiz.data.repositories.TechnologyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTechnologyByIdUseCase @Inject constructor(
    private val technologyRepository: TechnologyRepository
) {
    suspend operator fun invoke(id:Int): TechnologyEntity = withContext(Dispatchers.IO) {
        technologyRepository.getTechnologyById(id)
    }
}