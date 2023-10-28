package com.andreesperanca.feature_balanced_team.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreesperanca.database.model.Settings
import com.andreesperanca.feature_balanced_team.repository.SettingsBalancedTeamsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsBalancedTeamsViewModel(
    private val repository: SettingsBalancedTeamsRepository
) : ViewModel() {

    var playersUiState = MutableStateFlow(SettingsBalancedTeamsUiState())
        private set

    fun init() {
        fetchSettings()
    }

    suspend fun getSettings() = repository.fetchSettings()
    private fun fetchSettings() {
        viewModelScope.launch(Dispatchers.IO) {
            val settings = repository.fetchSettings()
            settings?.let {
                playersUiState.update { currentState ->
                    currentState.copy(settings = settings)
                }
            }
        }
    }
    fun saveSettings(settings: Settings) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveSettings(settings)
        }
    }
}

data class SettingsBalancedTeamsUiState(
    val settings: Settings = Settings(
        quantityTeams = 1,
        quantityPlayer = 1,
        useLevels = true
    ),
    val loadingState: Boolean = false
)
