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
import com.andreesperanca.camisanove.screen.MainScreen
import com.andreesperanca.feature_balanced_team.ui.screens.PlayersScreen
import com.andreesperanca.feature_balanced_team.ui.screens.SettingsBalancedTeams
import com.andreesperanca.ui_components.theme.C9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            C9Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    PlayersScreen()
//                    MainScreen()
                    SettingsBalancedTeams()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    C9Theme {

    }
}