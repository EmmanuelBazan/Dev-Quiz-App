package com.bazan.devquiz.data.database.data

import com.bazan.devquiz.data.database.dao.TechnologyDao
import com.bazan.devquiz.data.database.entities.TechnologyEntity

object TechnologyData {
    suspend fun populate(technologyDao: TechnologyDao) {
        technologyDao.insert(TechnologyEntity(name = "React", icon = 1, description = ""))
        technologyDao.insert(TechnologyEntity(name = "JavaScript", icon = 2, description = ""))
    }
}