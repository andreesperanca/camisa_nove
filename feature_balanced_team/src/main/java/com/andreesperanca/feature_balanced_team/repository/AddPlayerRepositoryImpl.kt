package com.andreesperanca.feature_balanced_team.repository

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.andreesperanca.database.model.Player
import com.andreesperanca.database.dao.PlayerDao

class AddPlayerRepositoryImpl(
    private val database: PlayerDao
) : AddPlayerRepository {

    override suspend fun addPlayer(player: Player) = database.insertPlayer(player = player)

}