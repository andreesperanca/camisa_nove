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

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val addPlayersRepository: AddPlayerRepository
    val playersRepository: PlayersRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    val database = AppDatabase.getDatabase(context).playersDao()

    override val addPlayersRepository: AddPlayerRepository by lazy {
        AddPlayerRepositoryImpl(database)
    }
    override val playersRepository: PlayersRepository by lazy {
        PlayersRepositoryImpl(database)
    }
}
