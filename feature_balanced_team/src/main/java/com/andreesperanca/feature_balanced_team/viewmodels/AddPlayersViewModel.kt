package com.andreesperanca.feature_balanced_team.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreesperanca.database.model.Player
import com.andreesperanca.feature_balanced_team.repository.AddPlayerRepository
import kotlinx.coroutines.launch

class AddPlayersViewModel(
    private val repository: AddPlayerRepository
) : ViewModel() {

    private val event = MutableLiveData<UiEventAddPlayers>()
    var _event : MutableLiveData<UiEventAddPlayers> = event

    fun addPlayer(player: Player) {
        viewModelScope.launch {
            repository.addPlayer(player)
            event.postValue(UiEventAddPlayers.showSnackBar(player.name))
        }
    }
}

sealed class UiEventAddPlayers(message: String) {
    data class showSnackBar (private val message: String): UiEventAddPlayers(message)
}