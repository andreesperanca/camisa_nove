package com.andreesperanca.feature_balanced_team.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.andreesperanca.database.model.Player
import com.andreesperanca.database.model.Settings
import com.andreesperanca.feature_balanced_team.R
import com.andreesperanca.feature_balanced_team.repository.PlayersRepository
import com.andreesperanca.feature_balanced_team.repository.SettingsBalancedTeamsRepository
import com.andreesperanca.feature_balanced_team.ui.components.PlayerItem
import com.andreesperanca.feature_balanced_team.utils.Teams
import com.andreesperanca.feature_balanced_team.viewmodels.PlayersViewModel
import com.andreesperanca.ui_components.R.drawable
import com.andreesperanca.ui_components.components.buttons.ButtonLarge
import com.andreesperanca.ui_components.components.buttons.ButtonMedium
import com.andreesperanca.ui_components.components.texts.DescriptionMedium
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.C9Theme
import com.andreesperanca.ui_components.theme.md_theme_light_surfaceContainer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun PlayersScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: PlayersViewModel,
    navigateToSettingsScreen: () -> Unit,
    navigateToAddPlayersScreen: () -> Unit,
    navigateToTeamsBalancedScreen: () -> Unit,
    navigateToBackStack: () -> Unit,
) {

    viewModel.init()

    val snackBarHostState = remember { SnackbarHostState() }


    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = md_theme_light_surfaceContainer
                ),
                title = {
                    TitleMedium(text = stringResource(R.string.feature_balanced_team_balance_teams))
                },
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .clickable { navigateToBackStack() }
                            .padding(PaddingValues(8.dp)),
                        tint = MaterialTheme.colorScheme.onSurface,
                        painter = painterResource(id = drawable.ic_back),
                        contentDescription = stringResource(R.string.feature_balanced_team_back_button_description)
                    )
                }
            )
        },
        content = {
            Box(modifier = Modifier
                .padding(it)
                .fillMaxSize()
            )
            {

                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.surface)
                        .align(Alignment.TopCenter)
                ) {


                    ButtonMedium(
                        title = stringResource(id = R.string.settings),
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(id = R.dimen.padding_medium),
                                top = dimensionResource(id = R.dimen.padding_large)
                            ),
                        onClickCta = {
                            navigateToSettingsScreen()
                        },
                    )


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = dimensionResource(R.dimen.padding_medium),
                                start = dimensionResource(R.dimen.padding_medium),
                                end = dimensionResource(R.dimen.padding_medium)
                            ),
                    ) {

                        Box(modifier = Modifier) {
                            TitleMedium(
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                                    .fillMaxWidth(),
                                text = stringResource(
                                    id = R.string.feature_balanced_players,
                                    viewModel.playersUiState.value.playersList.size.toString()
                                )
                            )
                            Icon(
                                modifier = Modifier
                                    .clickable { navigateToAddPlayersScreen() }
                                    .padding(PaddingValues(dimensionResource(id = R.dimen.padding_small)))
                                    .align(Alignment.CenterEnd),
                                painter = painterResource(id = drawable.ic_add),
                                contentDescription = ""
                            )
                        }
                    }

                    DescriptionMedium(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = dimensionResource(R.dimen.padding_medium),
                                end = dimensionResource(R.dimen.padding_medium)
                            ),
                        text = stringResource(R.string.players_screen_description)
                    )

                    LazyColumn(
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(id = R.dimen.padding_medium),
                                end = dimensionResource(id = R.dimen.padding_medium),
                                bottom = 100.dp,
                                top = dimensionResource(id = R.dimen.padding_small)
                            )
                            .background(Color(0xFFEFEDF1))
                    ) {
                        itemsIndexed(viewModel.playersUiState.value.playersList) { index, player ->
                            PlayerItem(
                                player = player,
                                deletePlayerAction = { viewModel.deletePlayer(player) },
                            )
                            if (index != viewModel.playersUiState.value.playersList.lastIndex) {
                                Divider(
                                    modifier = Modifier
                                        .align(Alignment.Start),
                                    thickness = 0.8.dp,
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
                                )
                            }
                        }
                    }
                }

                ButtonLarge(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .align(Alignment.BottomCenter),
                    onClickCta = {
                        viewModel.initBalancedTeams(
                            navigateToTeamsBalanced = {
                                val mainScope = CoroutineScope(Dispatchers.Main)
                                mainScope.launch {
                                    navigateToTeamsBalancedScreen()
                                }
                            },
                            showError = {
                                val scope = CoroutineScope(Dispatchers.IO)
                                scope.launch {
                                    snackBarHostState.showSnackbar("Error")
                                }
                            }
                        )
                        if (viewModel.playersUiState.value.error) {
                            val scope = CoroutineScope(Dispatchers.IO)
                        }
                    },
                    title = stringResource(id = R.string.generated_teams),
                )
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }

    )
}

@Preview(showBackground = true)
@Composable
fun PlayersScreenPreview() {

    class Ola() : PlayersRepository {
        override suspend fun fetchPlayers(): List<Player> {
            TODO("Not yet implemented")
        }

        override suspend fun deletePlayer(player: Player) {
            TODO("Not yet implemented")
        }
    }


    class Asdasd() : SettingsBalancedTeamsRepository {
        override suspend fun saveSettings(settings: Settings) {
            TODO("Not yet implemented")
        }

        override suspend fun fetchSettings(): Settings? {
            TODO("Not yet implemented")
        }

        override suspend fun fetchPlayers(): List<Player> {
            TODO("Not yet implemented")
        }
    }

    C9Theme {
        val navController = rememberNavController()
        PlayersScreen(
            navController = navController,
            viewModel = PlayersViewModel(Ola(), Asdasd()),
            navigateToAddPlayersScreen = {},
            navigateToSettingsScreen = {},
            navigateToTeamsBalancedScreen = {},
            navigateToBackStack = {}
        )
    }
}