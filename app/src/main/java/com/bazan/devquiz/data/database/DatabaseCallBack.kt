package com.bazan.devquiz.data.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bazan.devquiz.data.database.dao.DifficultyDao
import com.bazan.devquiz.data.database.dao.TechnologyDao
import com.bazan.devquiz.data.database.entities.DifficultyEntity
import com.bazan.devquiz.data.database.entities.TechnologyEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DatabaseCallBack @Inject constructor(
    private val technologyDaoProvider: javax.inject.Provider<TechnologyDao>,
    private val difficultyDaoProvider: javax.inject.Provider<DifficultyDao>
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        CoroutineScope(Dispatchers.IO).launch {
            populateDatabase(technologyDaoProvider.get(), difficultyDaoProvider.get())
        }
    }

    private suspend fun populateDatabase(technologyDao: TechnologyDao, difficultyDao: DifficultyDao) {
        // Insertar dificultades
        difficultyDao.insert(DifficultyEntity(id = 1, name = "Fácil", description = ""))
        difficultyDao.insert(DifficultyEntity(id = 2, name = "Intermedio", description = ""))
        difficultyDao.insert(DifficultyEntity(id = 3, name = "Difícil", description = ""))

        // Insertar tecnologías
        technologyDao.insert(TechnologyEntity(id = 1, name = "React", icon = 1, description = ""))
    }
}
