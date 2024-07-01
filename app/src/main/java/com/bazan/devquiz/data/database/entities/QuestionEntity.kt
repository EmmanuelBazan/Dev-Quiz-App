package com.bazan.devquiz.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "question_table",
    foreignKeys = [
        ForeignKey(
            entity = TechnologyEntity::class,
            parentColumns = ["id"],
            childColumns = ["technology"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = DifficultyEntity::class,
            parentColumns = ["id"],
            childColumns = ["difficulty"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "question")val question: String,
    @ColumnInfo(name = "answer") val answer: String,
    @ColumnInfo(name = "technology") val technology: Int,
    @ColumnInfo(name = "difficulty") val difficulty: Int,
)
