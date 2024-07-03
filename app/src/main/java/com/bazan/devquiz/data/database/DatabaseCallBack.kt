package com.bazan.devquiz.data.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bazan.devquiz.data.database.dao.DifficultyDao
import com.bazan.devquiz.data.database.dao.QuestionDao
import com.bazan.devquiz.data.database.dao.TechnologyDao
import com.bazan.devquiz.data.database.data.DifficultyData
import com.bazan.devquiz.data.database.data.QuestionData
import com.bazan.devquiz.data.database.data.TechnologyData
import com.bazan.devquiz.data.database.entities.DifficultyEntity
import com.bazan.devquiz.data.database.entities.QuestionEntity
import com.bazan.devquiz.data.database.entities.TechnologyEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class DatabaseCallBack @Inject constructor(
    private val technologyDaoProvider: Provider<TechnologyDao>,
    private val difficultyDaoProvider: Provider<DifficultyDao>,
    private val questionDaoProvider: Provider<QuestionDao>,
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        CoroutineScope(Dispatchers.IO).launch {
            populateDatabase(
                technologyDaoProvider.get(),
                difficultyDaoProvider.get(),
                questionDaoProvider.get()
            )
        }
    }

    private suspend fun populateDatabase(
        technologyDao: TechnologyDao,
        difficultyDao: DifficultyDao,
        questionDao: QuestionDao
    ) {
        DifficultyData.populate(difficultyDao)
        TechnologyData.populate(technologyDao)
        QuestionData.populate(questionDao)
    }
}
