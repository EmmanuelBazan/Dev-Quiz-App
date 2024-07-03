package com.bazan.devquiz.data.repositories

import com.bazan.devquiz.data.database.dao.QuestionDao
import com.bazan.devquiz.data.database.relations.FullQuestion
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val questionDao: QuestionDao
) {
    suspend fun getQuestionByTechAndDifficulty(idTech:Int,idDifficulty:Int): List<FullQuestion> {
        return questionDao.getQuestionByTechAndDifficulty(idTech,idDifficulty)
    }
}