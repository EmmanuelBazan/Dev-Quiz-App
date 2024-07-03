package com.bazan.devquiz.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.bazan.devquiz.data.database.entities.QuestionEntity
import com.bazan.devquiz.data.database.relations.FullQuestion

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(question:QuestionEntity)

    @Transaction
    @Query("SELECT * FROM question_table WHERE technology = :idTech AND difficulty = :idDifficulty")
    suspend fun getQuestionByTechAndDifficulty(idTech:Int,idDifficulty:Int): List<FullQuestion>
}