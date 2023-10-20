package com.andreesperanca.feature_balanced_team.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.andreesperanca.database.model.Settings
import com.andreesperanca.feature_balanced_team.R
import com.andreesperanca.feature_balanced_team.repository.SettingsBalancedTeamsRepository
import com.andreesperanca.feature_balanced_team.viewmodels.SettingsBalancedTeamsViewModel
import com.andreesperanca.ui_components.components.buttons.ButtonLarge
import com.andreesperanca.ui_components.components.texts.DescriptionMedium
import com.andreesperanca.ui_components.components.texts.HeaderLarge
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.C9Theme
import com.example.compose.md_theme_light_surfaceContainer
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsBalancedTeamsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SettingsBalancedTeamsViewModel
) {

    var levelBalanced by remember { mutableStateOf(true) }

    val uiState = viewModel.playersUiState.collectAsState().value
    var playersSliderPosition by remember { mutableIntStateOf(uiState.settings.quantityPlayer) }
    var teamsSliderPosition by remember { mutableIntStateOf(uiState.settings.quantityTeams) }

    LaunchedEffect(uiState.settings) {
        viewModel.init()
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Scaffold(
            topBar = {},

            content = {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.surface)
                        .align(Alignment.TopCenter)
                        .padding(it)
                        .verticalScroll(rememberScrollState())
                ) {

                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = md_theme_light_surfaceContainer
                        ),
                        title = {
                            TitleMedium(text = stringResource(R.string.feature_balanced_team_settings))
                        },
                        navigationIcon = {
                            Icon(
                                modifier = Modifier
                                    .clickable { navController.popBackStack() }
                                    .padding(PaddingValues(dimensionResource(id = R.dimen.padding_small))),
                                tint = MaterialTheme.colorScheme.onSurface,
                                painter = painterResource(id = com.andreesperanca.ui_components.R.drawable.ic_back),
                                contentDescription = stringResource(R.string.feature_balanced_team_back_button_description)
                            )
                        }
                    )

                    TitleMedium(
                        modifier = Modifier
                            .padding(
                                top = dimensionResource(id = R.dimen.padding_large),
                                start = dimensionResource(
                                    id = R.dimen.padding_medium
                                )
                            )
                            .fillMaxWidth(),
                        text = stringResource(
                            id = R.string.feature_balanced_players_title
                        )
                    )

                    DescriptionMedium(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = dimensionResource(R.dimen.padding_medium),
                                end = dimensionResource(R.dimen.padding_medium)
                            ),
                        text = stringResource(R.string.feature_balanced_players_description)
                    )

                    HeaderLarge(
                        modifier = Modifier.padding(
                            top = dimensionResource(id = R.dimen.padding_medium),
                            start = dimensionResource(id = R.dimen.padding_medium)
                        ),
                        text = playersSliderPosition.toString()
                    )

                    Slider(
                        modifier = Modifier.padding(
                            top = dimensionResource(id = R.dimen.padding_medium),
                            start = dimensionResource(id = R.dimen.padding_medium),
                            end = dimensionResource(id = R.dimen.padding_medium)
                        ),
                        value = playersSliderPosition.toFloat(),
                        onValueChange = { newValue ->
                            playersSliderPosition = newValue.roundToInt()
                        },
                        colors = SliderDefaults.colors(),
                        valueRange = 1f..10f
                    )

                    TitleMedium(
                        modifier = Modifier
                            .padding(
                                top = dimensionResource(id = R.dimen.padding_large),
                                start = dimensionResource(
                                    id = R.dimen.padding_medium
                                )
                            )
                            .fillMaxWidth(),
                        text = stringResource(
                            id = R.string.feature_balanced_teams_title
                        )
                    )

                    DescriptionMedium(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = dimensionResource(R.dimen.padding_medium),
                                end = dimensionResource(R.dimen.padding_medium)
                            ),
                        text = stringResource(R.string.feature_balanced_teams_description)
                    )

                    HeaderLarge(
                        modifier = Modifier.padding(
                            top = dimensionResource(id = R.dimen.padding_medium),
                            start = dimensionResource(id = R.dimen.padding_medium)
                        ),
                        text = teamsSliderPosition.toString()
                    )

                    Slider(
                        modifier = Modifier.padding(
                            top = dimensionResource(id = R.dimen.padding_medium),
                            start = dimensionResource(id = R.dimen.padding_medium),
                            end = dimensionResource(id = R.dimen.padding_medium)
                        ),
                        value = teamsSliderPosition.toFloat(),
                        onValueChange = { newValue ->
                            teamsSliderPosition = newValue.roundToInt()
                        },
                        colors = SliderDefaults.colors(),
                        valueRange = 1f..10f
                    )


                    ListItem(
                        modifier = Modifier.padding(
                            top = dimensionResource(id = R.dimen.padding_medium),
                            start = dimensionResource(id = R.dimen.padding_medium),
                            end = dimensionResource(id = R.dimen.padding_medium),
                            bottom = dimensionResource(id = R.dimen.padding_large)
                        ),
                        headlineContent = {
                            TitleMedium(
                                text = stringResource(id = R.string.feature_balanced_use_levels_title)
                            )
                        },
                        supportingContent = {
                            DescriptionMedium(text = stringResource(id = R.string.feature_balanced_use_levels_description))
                        },
                        trailingContent = {
                            Checkbox(
                                levelBalanced,
                                onCheckedChange = {
                                    levelBalanced = !levelBalanced
                                })
                        },
                        colors = ListItemDefaults.colors(
                            containerColor = md_theme_light_surfaceContainer
                        )
                    )
                }

            },
            bottomBar = {
                ButtonLarge(
                    modifier = Modifier
                        .padding(bottom = dimensionResource(id = R.dimen.padding_medium))
                        .align(Alignment.BottomCenter),
                    onClickCta = {
                        val newSettings = Settings(
                            quantityTeams = teamsSliderPosition,
                            quantityPlayer = playersSliderPosition,
                            useLevels = levelBalanced
                        )
                        viewModel.saveSettings(newSettings)
                        navController.popBackStack()
                    },
                    title = stringResource(id = R.string.feature_balanced_apply),
                )
            }

        )
    }
}

@Preview
@Composable
fun SettingsBalancedTeamsPreview() {

    C9Theme {

    }
}