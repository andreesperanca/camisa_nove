package com.andreesperanca.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andreesperanca.database.model.Player
import com.andreesperanca.database.model.Settings

@Dao
interface SettingsDao {
    @Query("SELECT * FROM settings")
    suspend fun getSettings(): Settings?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSettings(settings : Settings)

    @Query("SELECT * FROM players")
    suspend fun fetchAllPlayers(): List<Player>

}