package com.bazan.devquiz.data.repositories

import com.bazan.devquiz.data.database.dao.DifficultyDao
import com.bazan.devquiz.data.database.entities.DifficultyEntity
import javax.inject.Inject

class DifficultyRepository @Inject constructor(
    private val difficultyDao: DifficultyDao
) {
    suspend fun getAllDiffulty(): List<DifficultyEntity> {
        return difficultyDao.getAllDifficulty()
    }
}