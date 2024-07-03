package com.bazan.devquiz.domain.useCases.question

import com.bazan.devquiz.data.database.relations.FullQuestion
import com.bazan.devquiz.data.repositories.QuestionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetQuestionByTechAndDifficultyUseCase @Inject constructor(
    private val questionRepository: QuestionRepository
) {
    suspend operator fun invoke(idTech:Int,idDifficulty:Int): List<FullQuestion> = withContext(Dispatchers.IO) {
        questionRepository.getQuestionByTechAndDifficulty(idTech, idDifficulty)
    }
}