package com.andreesperanca.feature_balanced_team.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.feature_balanced_team.R
import com.andreesperanca.feature_balanced_team.data.playerList
import com.andreesperanca.feature_balanced_team.ui.components.PlayerItem
import com.andreesperanca.ui_components.R.*
import com.andreesperanca.ui_components.components.buttons.ButtonLarge
import com.andreesperanca.ui_components.components.buttons.ButtonMedium
import com.andreesperanca.ui_components.components.texts.DescriptionMedium
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.C9Theme
import com.example.compose.md_theme_light_surfaceContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.surface)
                .align(Alignment.TopCenter)
        ) {

            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = md_theme_light_surfaceContainer
                ),
                title = {
                    TitleMedium(text = stringResource(R.string.feature_balanced_team_balance_teams))
                },
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(PaddingValues(8.dp)),
                        tint = MaterialTheme.colorScheme.onSurface,
                        painter = painterResource(id = drawable.ic_back),
                        contentDescription = stringResource(R.string.feature_balanced_team_back_button_description)
                    )
                }
            )

            ButtonMedium(
                title = stringResource(id = R.string.settings),
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_medium),
                        top = dimensionResource(id = R.dimen.padding_large)
                    ),
                onClickCta = {},
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
                            playerList.size.toString()
                        )
                    )
                    Icon(
                        modifier = Modifier
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
                        end = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small)
                    ),
                text = stringResource(R.string.players_screen_description)
            )

            LazyColumn(
                modifier = Modifier
                    .background(Color(0xFFEFEDF1))
            ) {
                items(playerList) {
                    PlayerItem(player = it)
                }
            }

        }

        ButtonLarge(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.BottomCenter),
            onClickCta = {

            },
            title = stringResource(id = R.string.generated_teams),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlayersScreenPreview() {
    C9Theme {
        PlayersScreen()
    }
}