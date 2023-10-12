package com.andreesperanca.feature_balanced_team.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.andreesperanca.feature_balanced_team.R
import com.andreesperanca.ui_components.components.buttons.ButtonLarge
import com.andreesperanca.ui_components.components.texts.DescriptionMedium
import com.andreesperanca.ui_components.components.texts.HeaderLarge
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.C9Theme
import com.example.compose.md_theme_light_surfaceContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPlayerScreen(modifier: Modifier = Modifier) {

    var levelBalanced by remember { mutableStateOf(true) }

    var nameEditText by remember { mutableStateOf("") }

    var levelSlider by remember { mutableFloatStateOf(0.5f) }

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
                            modifier = Modifier.padding(PaddingValues(dimensionResource(id = R.dimen.padding_small))),
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
                                text = stringResource(id = R.string.feature_balanced_insert_player_name))
                                },
                        value = nameEditText,
                        onValueChange = { string ->
                            nameEditText = string
                        })

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
                        text = levelSlider.toString()
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
                        steps = 10,
                        valueRange = 0.5f..10f
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

                    },
                    title = stringResource(id = R.string.feature_balanced_add_player),
                )
            }

        )
    }
}

@Preview
@Composable
fun AddPlayerScreenPreview() {
    C9Theme {
        AddPlayerScreen()
    }
}