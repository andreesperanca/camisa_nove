package com.andreesperanca.feature_balanced_team.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreesperanca.database.model.Player
import com.andreesperanca.feature_balanced_team.repository.AddPlayerRepository
import kotlinx.coroutines.launch

class AddPlayersViewModel(
    private val repository: AddPlayerRepository
) : ViewModel() {

    fun addPlayer(player: Player) {
        viewModelScope.launch {
            repository.addPlayer(player)
        }
    }
}