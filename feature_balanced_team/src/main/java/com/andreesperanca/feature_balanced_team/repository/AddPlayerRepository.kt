package com.andreesperanca.feature_balanced_team.repository

import com.andreesperanca.database.model.Player

interface AddPlayerRepository {
    suspend fun addPlayer(player: Player)

}