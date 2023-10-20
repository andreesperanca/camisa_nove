package com.andreesperanca.camisanove.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.andreesperanca.camisanove.screen.MainScreen
import com.andreesperanca.feature_balanced_team.ui.screens.AddPlayerScreen
import com.andreesperanca.feature_balanced_team.ui.screens.BalancedTeamsScreen
import com.andreesperanca.feature_balanced_team.ui.screens.PlayersScreen
import com.andreesperanca.feature_balanced_team.ui.screens.SettingsBalancedTeamsScreen
import com.andreesperanca.feature_balanced_team.viewmodels.AddPlayersViewModel
import com.andreesperanca.feature_balanced_team.viewmodels.PlayersViewModel
import com.andreesperanca.feature_balanced_team.viewmodels.SettingsBalancedTeamsViewModel

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    addPlayersViewModel: AddPlayersViewModel,
    playersViewModel: PlayersViewModel,
    settingsBalancedTeamsViewModel: SettingsBalancedTeamsViewModel
) {
    NavHost(
        navController = navController,
        route = AppGraph.home.ROOT,
        startDestination = AppGraph.home.HOME
    )
    {
        composable(route = AppGraph.home.HOME) {
            MainScreen(
                navigateToBalancedTeamFeature = { navController.navigate(AppGraph.teams_balanced.ROOT) }
            )
        }
        teamsBalancedFeatureGraph(
            navController,
            addPlayersViewModel,
            playersViewModel,
            settingsBalancedTeamsViewModel
        )
    }
}

fun NavGraphBuilder.teamsBalancedFeatureGraph(
    navController: NavHostController,
    addPlayersViewModel: AddPlayersViewModel,
    playersViewModel: PlayersViewModel,
    settingsBalancedTeamsViewModel: SettingsBalancedTeamsViewModel
    ) {
    navigation(
        route = AppGraph.teams_balanced.ROOT,
        startDestination = AppGraph.teams_balanced.PLAYERS
    ) {
        composable(route = AppGraph.teams_balanced.PLAYERS) {
            PlayersScreen(
                navController = navController,
                viewModel = playersViewModel,
                navigateToTeamsBalancedScreen = { navController.navigate(AppGraph.teams_balanced.BALANCED_TEAMS) },
                navigateToSettingsScreen = { navController.navigate(AppGraph.teams_balanced.SETTINGS) },
                navigateToAddPlayersScreen = { navController.navigate(AppGraph.teams_balanced.ADD_PLAYER) },
                navigateToBackStack = { navController.popBackStack() }
            )
        }
        composable(route = AppGraph.teams_balanced.ADD_PLAYER) {
            AddPlayerScreen(
                navController = navController,
                viewModel = addPlayersViewModel
            )
        }
        composable(route = AppGraph.teams_balanced.SETTINGS) {
            SettingsBalancedTeamsScreen(
                navController = navController,
                viewModel = settingsBalancedTeamsViewModel
                )
        }
        composable(route = AppGraph.teams_balanced.BALANCED_TEAMS) {
            BalancedTeamsScreen(navController = navController)
        }
    }
}