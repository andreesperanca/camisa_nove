package com.andreesperanca.feature_balanced_team.repository

import com.andreesperanca.database.model.Player

interface PlayersRepository {
    suspend fun fetchPlayers() : List<Player>
    suspend fun deletePlayer(player: Player)
}