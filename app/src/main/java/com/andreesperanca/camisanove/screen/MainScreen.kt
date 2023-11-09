 package com.andreesperanca.camisanove.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.camisanove.R
import com.andreesperanca.ui_components.R.*
import com.andreesperanca.ui_components.theme.C9Theme

 @OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navigateToBalancedTeamFeature: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFEFEDF1)
                ),
                title = {
                    Text(
                        color = MaterialTheme.colorScheme.primary,
                        text = stringResource(id = R.string.app_name)
                    )
                },
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .alpha(0f)
                            .padding(PaddingValues(8.dp)),
                        tint = Color(0xFF45464F),
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = stringResource(id = R.string.app_main_screen_menu),
                    )
                },
                actions = {
                    Icon(
                        modifier = Modifier
                            .alpha(0f)
                            .padding(PaddingValues(8.dp)),
                        tint = Color(0xFF45464F),
                        painter = painterResource(id = R.drawable.ic_account),
                        contentDescription = stringResource(id = R.string.app_main_screen_my_account)
                    )
                }
            )
        }
    ) {
        Column(
            modifier =
            Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxSize()
                .background(Color(0xFFFBF8FD))

        ) {
            Spacer(modifier = Modifier.padding(top = dimensionResource(id = dimen.padding_large)))

            Text(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = dimen.padding_medium)
                ),
                text = stringResource(R.string.main_screen_feedback_message),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = dimen.padding_medium)
                ),
                text = stringResource(R.string.main_screen_feedback_description),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Box(modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(
                            top = dimensionResource(id = dimen.padding_small),
                            end = dimensionResource(id = dimen.padding_large)
                        ),
                    onClick = {

                    },
                ) {
                    Text(text = stringResource(R.string.main_screen_feedback_message_cta_title))
                }
            }

            Spacer(modifier = Modifier.padding(top = dimensionResource(id = dimen.padding_large)))

            Text(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = dimen.padding_medium)
                ),
                text = stringResource(R.string.main_screen_balanced_teams_title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = dimen.padding_medium)
                ),
                text = stringResource(R.string.main_screen_balanced_teams_description),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Box(modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(
                            top = dimensionResource(id = dimen.padding_small),
                            end = dimensionResource(id = dimen.padding_large)
                        ),
                    onClick = {

                    },
                ) {
                    Text(text = stringResource(R.string.main_screen_balanced_teams_cta_title))
                }
            }

            Spacer(modifier = Modifier.padding(top = dimensionResource(id = dimen.padding_large)))

            Text(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = dimen.padding_medium)
                ),
                text = stringResource(R.string.main_screen_beta_version_title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = dimen.padding_medium)
                ),
                text = stringResource(R.string.main_screen_beta_version_description),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
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