package com.andreesperanca.feature_balanced_team.repository

import com.andreesperanca.database.dao.SettingsDao
import com.andreesperanca.database.model.Player
import com.andreesperanca.database.model.Settings


class SettingsBalancedTeamsRepositoryImpl(
    private val settingsDatabase: SettingsDao
) : SettingsBalancedTeamsRepository {
    override suspend fun saveSettings(settings: Settings) = settingsDatabase.saveSettings(settings)

    override suspend fun fetchSettings(): Settings? = settingsDatabase.getSettings()

    override suspend fun fetchPlayers(): List<Player> = settingsDatabase.fetchAllPlayers()
}