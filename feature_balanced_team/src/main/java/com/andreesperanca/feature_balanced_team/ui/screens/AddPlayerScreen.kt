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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.andreesperanca.database.model.Player
import com.andreesperanca.feature_balanced_team.R
import com.andreesperanca.feature_balanced_team.utils.isValidName
import com.andreesperanca.feature_balanced_team.viewmodels.AddPlayersViewModel
import com.andreesperanca.ui_components.components.buttons.ButtonLarge
import com.andreesperanca.ui_components.components.texts.DescriptionMedium
import com.andreesperanca.ui_components.components.texts.HeaderLarge
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.C9Theme
import com.example.compose.md_theme_light_surfaceContainer
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPlayerScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AddPlayersViewModel
) {
    var specialPlayer by remember { mutableStateOf(false) }

    var nameEditText by remember { mutableStateOf("") }

    var levelSlider by remember { mutableFloatStateOf(0.5f) }
    val levelFormat = String.format("%.1f", levelSlider)

    var playerNameIsInvalid by rememberSaveable { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }

    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = md_theme_light_surfaceContainer
                    ),
                    title = {
                        TitleMedium(text = stringResource(R.string.feature_balanced_team_add_player))
                    },
                    navigationIcon = {
                        Icon(
                            modifier = Modifier
                                .clickable { navController.popBackStack() }
                                .padding(PaddingValues(dimensionResource(id = R.dimen.padding_small)))
                            ,
                            tint = MaterialTheme.colorScheme.onSurface,
                            painter = painterResource(id = com.andreesperanca.ui_components.R.drawable.ic_back),
                            contentDescription = stringResource(R.string.feature_balanced_team_back_button_description)
                        )
                    }
                )
            },
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
                            id = R.string.feature_balanced_add_player_title
                        )
                    )

                    DescriptionMedium(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = dimensionResource(R.dimen.padding_medium),
                                end = dimensionResource(R.dimen.padding_medium)
                            ),
                        text = stringResource(R.string.feature_balanced_add_player_description)
                    )


                    TitleMedium(
                        modifier = Modifier
                            .padding(
                                top = dimensionResource(id = R.dimen.padding_medium),
                                start = dimensionResource(
                                    id = R.dimen.padding_medium
                                )
                            )
                            .fillMaxWidth(),
                        text = stringResource(
                            id = R.string.feature_balanced_name
                        )
                    )

                    OutlinedTextField(modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(id = R.dimen.padding_small),
                            start = dimensionResource(id = R.dimen.padding_medium),
                            end = dimensionResource(id = R.dimen.padding_medium)
                        ),
                        label = {
                            Text(
                                style = MaterialTheme.typography.bodySmall,
                                text = stringResource(id = R.string.feature_balanced_insert_player_name)
                            )
                        },
                        value = nameEditText,
                        onValueChange = { string ->
                            nameEditText = string
                            playerNameIsInvalid = false
                        },
                        isError = playerNameIsInvalid,
                        supportingText = {
                            if (playerNameIsInvalid) {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = stringResource(id = R.string.feature_balanced_add_player_invalid_name),
                                    color = MaterialTheme.colorScheme.error
                                )
                            }
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
                            id = R.string.feature_balanced_level_title
                        )
                    )

                    DescriptionMedium(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = dimensionResource(R.dimen.padding_medium),
                                end = dimensionResource(R.dimen.padding_medium)
                            ),
                        text = stringResource(R.string.feature_balanced_level_description)
                    )

                    HeaderLarge(
                        modifier = Modifier.padding(
                            top = dimensionResource(id = R.dimen.padding_medium),
                            start = dimensionResource(id = R.dimen.padding_medium)
                        ),
                        text = levelFormat
                    )

                    Slider(
                        modifier = Modifier.padding(
                            top = dimensionResource(id = R.dimen.padding_small),
                            start = dimensionResource(id = R.dimen.padding_medium),
                            end = dimensionResource(id = R.dimen.padding_medium)
                        ),
                        value = levelSlider,
                        onValueChange = { levelSlider = it },
                        colors = SliderDefaults.colors(),
                        valueRange = 0.5f..5f
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
                                text = stringResource(id = R.string.feature_balanced_special_player_title)
                            )
                        },
                        supportingContent = {
                            DescriptionMedium(text = stringResource(id = R.string.feature_balanced_special_player_description))
                        },
                        trailingContent = {
                            Checkbox(
                                specialPlayer,
                                onCheckedChange = {
                                    specialPlayer = !specialPlayer
                                })
                        },
                        colors = ListItemDefaults.colors(containerColor = md_theme_light_surfaceContainer)
                    )
                }
            },


            bottomBar = {
                ButtonLarge(
                    modifier = Modifier
                        .padding(bottom = dimensionResource(id = R.dimen.padding_medium))
                        .align(Alignment.BottomCenter),
                    onClickCta = {
                        if (nameEditText.isValidName()) {
                            val newPlayer = Player(name = nameEditText, level = levelSlider)
                            viewModel.addPlayer(newPlayer)
                            nameEditText = ""
                            specialPlayer = false
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = context.getString(R.string.teams_balanced_add_players_screen_add_player_message, newPlayer.name),
                                    duration = SnackbarDuration.Short
                                )
                            }
                        } else {
                            playerNameIsInvalid = true
                        }
                    },
                    title = stringResource(id = R.string.feature_balanced_add_player),
                )
            },

            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            }
        )
    }
}

@Preview
@Composable
fun AddPlayerScreenPreview() {
    C9Theme {

    }
}