package com.andreesperanca.feature_balanced_team.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.andreesperanca.feature_balanced_team.data.mockTeamList
import com.andreesperanca.feature_balanced_team.ui.components.TeamItem
import com.andreesperanca.feature_balanced_team.utils.Teams
import com.andreesperanca.ui_components.R.drawable
import com.andreesperanca.ui_components.theme.C9Theme

@Composable
fun BalancedTeamsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = {
                 Box(modifier = Modifier.fillMaxWidth()) {
                     Icon(
                         modifier = Modifier
                             .padding(PaddingValues(16.dp))
                             .align(Alignment.CenterStart),
                         painter = painterResource(id = drawable.ic_close),
                         contentDescription = "")

                     Icon(
                         modifier = Modifier
                             .padding(PaddingValues(16.dp))
                             .align(Alignment.CenterEnd),
                         painter = painterResource(id = drawable.ic_share),
                         contentDescription = "")
                 }
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                items(Teams.teams) {team ->
                    TeamItem(team = team)
                }
            }
        }
    )
}

@Preview
@Composable
fun BalancedTeamsScreenPreview() {
    C9Theme {
//        BalancedTeamsScreen()
    }
}