package com.andreesperanca.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.andreesperanca.database.model.Player

@Dao
interface PlayerDao {
    @Query("SELECT * FROM players")
    suspend fun getAll(): List<Player>

    @Query("SELECT * FROM players WHERE uid IN (:playersIds)")
    suspend fun loadAllByIds(playersIds: IntArray): List<Player>

    @Insert
    suspend fun insertPlayer(player: Player)

    @Delete
    suspend fun delete(player: Player)
}