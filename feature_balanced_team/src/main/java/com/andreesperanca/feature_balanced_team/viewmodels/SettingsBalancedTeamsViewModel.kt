package com.andreesperanca.feature_balanced_team.viewmodels

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

    private fun fetchSettings() {
        viewModelScope.launch(Dispatchers.IO) {
            val settings = repository.fetchSettings()
            if (settings != null) {
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
        quantityPlayer = 1,
        useLevels = true,
        quantityTeams = 1
    ),
    val loadingState: Boolean = false
)
