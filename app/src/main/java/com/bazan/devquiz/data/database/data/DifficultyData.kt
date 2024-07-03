package com.bazan.devquiz.data.database.data

import com.bazan.devquiz.data.database.dao.DifficultyDao
import com.bazan.devquiz.data.database.entities.DifficultyEntity

object DifficultyData {
    suspend fun populate(difficultyDao: DifficultyDao) {
        difficultyDao.insert(DifficultyEntity(name = "Fácil", description = ""))
        difficultyDao.insert(DifficultyEntity(name = "Intermedio", description = ""))
        difficultyDao.insert(DifficultyEntity(name = "Difícil", description = ""))
    }
}