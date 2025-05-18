package com.bazan.devquiz.data.database.data

import com.bazan.devquiz.data.database.dao.TechnologyDao
import com.bazan.devquiz.data.database.entities.TechnologyEntity

object TechnologyData {
    suspend fun populate(technologyDao: TechnologyDao) {
        technologyDao.insert(TechnologyEntity(name = "React", icon = 1, description = ""))
        technologyDao.insert(TechnologyEntity(name = "JavaScript", icon = 2, description = ""))
        technologyDao.insert(TechnologyEntity(name = "Java", icon = 3, description = ""))
//        technologyDao.insert(TechnologyEntity(name = "Kotlin", icon = 4, description = ""))
//        technologyDao.insert(TechnologyEntity(name = "Swift", icon = 5, description = ""))
    }
}