package com.andreesperanca.feature_balanced_team.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreesperanca.database.model.Player
import com.andreesperanca.feature_balanced_team.repository.PlayersRepository
import kotlinx.coroutines.launch

class PlayersViewModel(
    private val repository: PlayersRepository
) : ViewModel() {
    var playersUiState = mutableStateOf(playersUiState())
        private set

    fun init() {
        fetchPlayers()
    }

    private fun fetchPlayers() {
        viewModelScope.launch {
            val players = repository.fetchPlayers()
            playersUiState.value = playersUiState.value.copy(
                playersList = players
            )
        }
    }

    fun deletePlayer(player: Player) {
        viewModelScope.launch {
            repository.deletePlayer(player)
            val players = repository.fetchPlayers()
            playersUiState.value = playersUiState.value.copy(
                playersList = players
            )
        }
    }


}

data class playersUiState(
    val playersList: List<Player> = emptyList()
)

