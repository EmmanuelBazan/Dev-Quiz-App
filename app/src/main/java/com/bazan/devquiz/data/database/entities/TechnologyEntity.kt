package com.bazan.devquiz.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "technology_table")
data class TechnologyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "icon") val icon: Int,
    @ColumnInfo(name = "description") val description: String
)