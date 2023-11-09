package com.andreesperanca.feature_balanced_team.ui.screens

import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.andreesperanca.database.model.Player
import com.andreesperanca.database.model.Team
import com.andreesperanca.feature_balanced_team.R
import com.andreesperanca.feature_balanced_team.ui.components.TeamItem
import com.andreesperanca.feature_balanced_team.utils.Image
import com.andreesperanca.ui_components.R.drawable
import com.andreesperanca.ui_components.theme.C9Theme
import dev.shreyaspatil.capturable.Capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController

@Composable
fun BalancedTeamsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    teams: MutableList<Team>,
    navigateToPlayersScreen: () -> Unit,
    navigateToShareTeams: () -> Unit,
) {

    val context = LocalContext.current
    val captureController = rememberCaptureController()
    val appName = stringResource(id = R.string.app_name)

    Scaffold(
        topBar = {
                 Box(modifier = Modifier
                     .padding(
                         start = dimensionResource(id = R.dimen.padding_small),
                         end = dimensionResource(id = R.dimen.padding_small),
                         top = dimensionResource(id = R.dimen.padding_medium)
                     )
                     .wrapContentHeight()
                     .fillMaxWidth()) {
                     Icon(
                         modifier = Modifier
                             .clickable { navigateToPlayersScreen() }
                             .padding(PaddingValues(dimensionResource(id = R.dimen.padding_small)))
                             .align(Alignment.CenterStart),
                         painter = painterResource(id = drawable.ic_close),
                         contentDescription = stringResource(id = R.string.close_screen_description))

                     Icon(
                         modifier = Modifier
                             .clickable { captureController.capture(Bitmap.Config.ARGB_8888) }
                             .padding(PaddingValues(dimensionResource(id = R.dimen.padding_small)))
                             .align(Alignment.CenterEnd),
                         painter = painterResource(id = drawable.ic_share),
                         contentDescription = stringResource(id = R.string.share_teams_description))
                 }
        },
        content = {

            Capturable(
                controller = captureController,
                onCaptured = { imageBitmap, error ->
                    if (imageBitmap != null) {
                        Image.saveToGallery(
                            context = context,
                            bitmap = imageBitmap,
                            albumName = appName
                            )
                    }
                    if (error != null) {
                        TODO()
                    }
                }) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                        .background(
                            color = MaterialTheme.colorScheme.surface,
                            shape = RectangleShape
                        )

                ) {
                    items(teams) { team ->
                        TeamItem(team = team)
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun BalancedTeamsScreenPreview() {
    val navController = rememberNavController()
    val teams = mutableListOf(
        Team(
            name = "1",
            players = mutableListOf(
                Player(uid = 1, name = "andre", level = 0f, isSpecialPLayer = false),
                Player(uid = 1, name = "andre", level = 0f, isSpecialPLayer = false),
                Player(uid = 1, name = "andre", level = 0f, isSpecialPLayer = false)
            )
        ),
        Team(
            name = "1",
            players = mutableListOf(
                Player(uid = 1, name = "andre", level = 0f, isSpecialPLayer = false),
                Player(uid = 1, name = "andre", level = 0f, isSpecialPLayer = false),
                Player(uid = 1, name = "andre", level = 0f, isSpecialPLayer = false)
            )
        )
    )
    C9Theme {
        BalancedTeamsScreen(
            navController = navController,
            teams = teams,
            navigateToShareTeams = {},
            navigateToPlayersScreen = {})
    }
}