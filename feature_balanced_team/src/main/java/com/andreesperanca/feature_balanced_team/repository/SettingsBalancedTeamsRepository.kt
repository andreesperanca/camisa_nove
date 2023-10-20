package com.andreesperanca.feature_balanced_team.repository

import com.andreesperanca.database.model.Player
import com.andreesperanca.database.model.Settings

interface SettingsBalancedTeamsRepository {
    suspend fun saveSettings(settings: Settings)
    suspend fun fetchSettings() : Settings?
    suspend fun fetchPlayers() : List<Player>
}