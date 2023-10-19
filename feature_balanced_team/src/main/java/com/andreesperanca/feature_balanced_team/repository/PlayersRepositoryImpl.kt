package com.andreesperanca.feature_balanced_team.repository

import com.andreesperanca.database.dao.PlayerDao
import com.andreesperanca.database.model.Player

class PlayersRepositoryImpl(
    private val database: PlayerDao
) : PlayersRepository {
    override suspend fun fetchPlayers(): List<Player>  = database.getAll()
    override suspend fun deletePlayer(player: Player) = database.delete(player = player)
}