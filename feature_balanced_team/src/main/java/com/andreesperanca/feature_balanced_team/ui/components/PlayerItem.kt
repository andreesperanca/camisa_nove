package com.andreesperanca.feature_balanced_team.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.database.model.Player
import com.andreesperanca.feature_balanced_team.R
import com.andreesperanca.ui_components.R.*
import com.andreesperanca.ui_components.theme.C9Theme
import com.andreesperanca.ui_components.theme.md_theme_light_surfaceContainer

@Composable
fun PlayerItem(
    modifier: Modifier = Modifier,
    player: Player,
    deletePlayerAction: () -> Unit
) {

    val playerLevel = stringResource(R.string.feature_balanced_team_player_level, String.format("%.1f", player.level))

    Surface(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .heightIn(50.dp)
    ) {
        Box(
            modifier = Modifier
                .background(md_theme_light_surfaceContainer)
                .padding(PaddingValues(dimensionResource(id = R.dimen.padding_medium)))
                .fillMaxWidth()
        ) {

            Column(modifier = Modifier.align(Alignment.CenterStart)) {
                Text(
                    text = player.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = playerLevel,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

            }

            Icon(
                modifier = Modifier
                    .clickable { deletePlayerAction() }
                    .align(Alignment.CenterEnd),
                painter = painterResource(id = drawable.ic_delete),
                tint = MaterialTheme.colorScheme.onSurface,
                contentDescription = stringResource(R.string.feature_balanced_team_back_button_description)
            )
        }
    }
}

@Preview
@Composable
fun PlayerItemPreview() {
    val player = Player(1, "André", 1.233f, false)
    C9Theme {
        PlayerItem(player = player, deletePlayerAction = {})
    }
}