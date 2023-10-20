package com.andreesperanca.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class Settings(
    @PrimaryKey val uid: Int = 0,
    val quantityPlayer: Int,
    val quantityTeams: Int,
    val useLevels: Boolean
)
