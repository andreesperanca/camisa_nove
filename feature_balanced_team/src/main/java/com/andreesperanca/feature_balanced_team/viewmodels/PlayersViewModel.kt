package com.andreesperanca.feature_balanced_team.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreesperanca.database.model.Player
import com.andreesperanca.database.model.Team
import com.andreesperanca.feature_balanced_team.repository.PlayersRepository
import com.andreesperanca.feature_balanced_team.repository.SettingsBalancedTeamsRepository
import com.andreesperanca.feature_balanced_team.utils.Teams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal

class PlayersViewModel(
    private val repository: PlayersRepository,
    private val settingsRepository: SettingsBalancedTeamsRepository
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

    fun initBalancedTeams(navigateToTeamsBalanced: () -> Unit, showError: () -> Unit)  {
        viewModelScope.launch(Dispatchers.IO) {
            val settings = settingsRepository.fetchSettings()
            if (settings != null) {
                if(playersUiState.value.playersList.size < settings.quantityPlayer) {
                    showError()
                } else {
                    playersUiState.value.playersList.size
                    val teams = balancedTeams(
                        teamsQuantity = settings.quantityTeams,
                        playersQuantity = settings.quantityPlayer
                    )
                    Teams.teams = teams
                    navigateToTeamsBalanced()
                }
            } else {
                showError()
            }
        }

    }

    private fun balancedTeams(
        teamsQuantity: Int,
        playersQuantity: Int,
    ): MutableList<Team> {

        val players = playersUiState.value.playersList as MutableList
        val teams = mutableListOf<Team>()

        for (i in 1..teamsQuantity) {
            teams.add(Team(name = "$i", players = mutableListOf()))
        }

        var maxTeamPoints = BigDecimal(0.0)

        players.forEach { player -> maxTeamPoints += player.level }

        val pointsForEachTeam = maxTeamPoints / teamsQuantity.toBigDecimal()

        val specialPlayers = players.filter { player -> player.isSpecialPLayer }

        specialPlayers.forEachIndexed { index, player ->
            if (teams.lastIndex >= index) {
                teams[index].players.add(player)
            }
        }

        val normalPlayers = players.filter { player -> !player.isSpecialPLayer }
        val normalPlayersAux = mutableListOf<Player>()
        normalPlayersAux.addAll(normalPlayers)

        teams.forEach { team ->
            var teamPoints = BigDecimal(0.0)
            for (i in 0 until normalPlayersAux.size) {

                if (normalPlayersAux.size != 0) {
                    val player = normalPlayersAux.random()
                    if ((teamPoints + player.level) < pointsForEachTeam) {
                        teamPoints += player.level
                        normalPlayersAux.remove(player)
                        team.players.add(player)
                    }
                } else {
                    return@forEach
                }
                if (teamPoints >= pointsForEachTeam || team.players.size >= playersQuantity) {
                    return@forEach
                }
            }
        }

        val teamsWithoutPlayers = teams.filter { team -> team.players.size < playersQuantity }

        teams.removeAll(teamsWithoutPlayers)

        teamsWithoutPlayers.sortedByDescending { team -> team.calculatePoints() }.apply {
            //Adicionar o jogador com menos pontos
            this.forEach { team ->
                if (normalPlayersAux.size != 0) {
                    normalPlayersAux.sortedByDescending { it.level }
                    team.players.add(normalPlayersAux.first())
                    normalPlayersAux.remove(normalPlayersAux.first())
                }
            }
        }

        teams.addAll(teamsWithoutPlayers)

        return teams
    }
}

data class playersUiState(
    val playersList: List<Player> = emptyList(),
    var error: Boolean = false,
    var canNavigate: Boolean = false
)

