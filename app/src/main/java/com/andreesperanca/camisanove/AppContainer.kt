/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.andreesperanca.camisanove

import android.content.Context
import com.andreesperanca.database.database.AppDatabase
import com.andreesperanca.database.model.Player
import com.andreesperanca.feature_balanced_team.repository.AddPlayerRepository
import com.andreesperanca.feature_balanced_team.repository.AddPlayerRepositoryImpl
import com.andreesperanca.feature_balanced_team.repository.PlayersRepository
import com.andreesperanca.feature_balanced_team.repository.PlayersRepositoryImpl
import com.andreesperanca.feature_balanced_team.repository.SettingsBalancedTeamsRepository
import com.andreesperanca.feature_balanced_team.repository.SettingsBalancedTeamsRepositoryImpl

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val addPlayersRepository: AddPlayerRepository
    val playersRepository: PlayersRepository
    val settingsBalancedTeamsRepository: SettingsBalancedTeamsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    private val playersDatabase = AppDatabase.getDatabase(context).playersDao()
    private val settingsDatabase = AppDatabase.getDatabase(context).settingsDao()

    override val addPlayersRepository: AddPlayerRepository by lazy {
        AddPlayerRepositoryImpl(playersDatabase)
    }
    override val playersRepository: PlayersRepository by lazy {
        PlayersRepositoryImpl(playersDatabase)
    }
    override val settingsBalancedTeamsRepository: SettingsBalancedTeamsRepository by lazy {
        SettingsBalancedTeamsRepositoryImpl(settingsDatabase)
    }
}