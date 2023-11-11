package com.andreesperanca.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.andreesperanca.database.util.BigDecimalConverter
import java.math.BigDecimal

@Entity(tableName = "players")
data class Player(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "level")
    @TypeConverters(BigDecimalConverter::class)
    val level: BigDecimal,
    @ColumnInfo(name = "special") val isSpecialPLayer: Boolean
)
