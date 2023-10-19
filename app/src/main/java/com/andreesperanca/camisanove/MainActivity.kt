package com.andreesperanca.camisanove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.andreesperanca.camisanove.navigation.RootNavigationGraph
import com.andreesperanca.camisanove.screen.MainScreen
import com.andreesperanca.feature_balanced_team.viewmodels.AddPlayersViewModel
import com.andreesperanca.feature_balanced_team.viewmodels.PlayersViewModel
import com.andreesperanca.ui_components.theme.C9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            C9Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    val addPlayersViewModel = AddPlayersViewModel(repository = AppDataContainer(this).addPlayersRepository)
                    val playersViewModel = PlayersViewModel(repository = AppDataContainer(this).playersRepository)


                    RootNavigationGraph(
                        navController,
                        addPlayersViewModel = addPlayersViewModel,
                        playersViewModel = playersViewModel
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    C9Theme {
        MainScreen(navigateToBalancedTeamFeature = {})
    }
}