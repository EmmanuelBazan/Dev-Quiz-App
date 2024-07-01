package com.bazan.devquiz.data.repositories

import com.bazan.devquiz.data.database.dao.TechnologyDao
import com.bazan.devquiz.data.database.entities.TechnologyEntity
import javax.inject.Inject

class TechnologyRepository @Inject constructor(
    private val technologyDao: TechnologyDao
) {
    suspend fun getAllTechnologies(): List<TechnologyEntity> {
        return technologyDao.getAllTechnologies()
    }

    suspend fun getTechnologyById(id: Int): TechnologyEntity {
        return technologyDao.getTechnologyById(id)
    }
}