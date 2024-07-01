package com.bazan.devquiz.data.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.bazan.devquiz.data.database.entities.DifficultyEntity
import com.bazan.devquiz.data.database.entities.ReminderEntity
import com.bazan.devquiz.data.database.entities.TechnologyEntity

data class ReminderFull(
    @Embedded val reminder: ReminderEntity,
    @Relation(
        parentColumn = "technology",
        entityColumn = "id"
    )
    val technology: TechnologyEntity,
    @Relation(
        parentColumn = "difficulty",
        entityColumn = "id"
    )
    val difficulty: DifficultyEntity
)
