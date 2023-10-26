package com.andreesperanca.feature_balanced_team.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreesperanca.database.model.Player
import com.andreesperanca.database.model.Team
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

    fun balancedTeams(): MutableList<Team> {
        val players = playersUiState.value.playersList as MutableList
        val teams = mutableListOf<Team>()
        val quantidadeDeTimes = 3
        val quantidadeDeJogadores = 5

        for (i in 1..quantidadeDeTimes) {
            teams.add(Team(name = "Team${i}", players = mutableListOf()))
        }

        var notasMaximas: Float = 0F

        players.forEach { player ->
            notasMaximas += player.level
        }

        val notaParaCadaTime = notasMaximas / quantidadeDeTimes

        println(notaParaCadaTime)

        // dividir jogadore exclusivos
        val specialPlayers = players.filter { player -> player.isSpecialPLayer }

        specialPlayers.forEachIndexed { index, player ->
            if(teams.lastIndex >= index) {
                teams[index].players.add(player)
            }
        }

        val normalPlayers = players.filter { player -> !player.isSpecialPLayer }
        val normalPlayersAux = mutableListOf<Player>()
        normalPlayersAux.addAll(normalPlayers)

        teams.forEach { team ->
            for (i in 0..4) {
                var valorDoTime = 0F

                if (normalPlayersAux.size != 0) {
                    val player = normalPlayersAux.random()
                    valorDoTime += player.level
                    normalPlayersAux.remove(player)
                    team.players.add(player)
                } else {
                    return@forEach
                }

                if (valorDoTime >= notasMaximas || team.players.size >= quantidadeDeJogadores) {
                    return@forEach
                }
            }
        }

        return teams
    }

}

data class playersUiState(
    val playersList: List<Player> = emptyList()
)

