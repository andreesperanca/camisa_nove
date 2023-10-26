package com.andreesperanca.feature_balanced_team.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.andreesperanca.ui_components.components.texts.SubtitleMedium
import com.andreesperanca.ui_components.theme.C9Theme
import com.example.compose.md_theme_light_surfaceContainer

@Composable
fun PlayerItem(
    modifier: Modifier = Modifier,
    player: Player,
    deletePlayerAction: () -> Unit
) {
    Surface(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .heightIn(50.dp)
            .padding(
                vertical = dimensionResource(id = R.dimen.padding_small),
                horizontal = dimensionResource(id = R.dimen.padding_medium)
            )
    ) {
        Row(
            modifier = Modifier
                .background(md_theme_light_surfaceContainer)
                .fillMaxWidth()
                .padding(PaddingValues(dimensionResource(id = R.dimen.padding_medium)))
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                SubtitleMedium(
                    modifier = Modifier.align(Alignment.CenterStart),
                    text = player.name,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Icon(
                    modifier = Modifier
                        .clickable { deletePlayerAction() }
                        .align(Alignment.CenterEnd),
                    painter = painterResource(id = com.andreesperanca.ui_components.R.drawable.ic_delete),
                    tint = MaterialTheme.colorScheme.onSurface,
                    contentDescription = stringResource(R.string.feature_balanced_team_back_button_description)
                )
            }
        }
    }
}

@Preview
@Composable
fun PlayerItemPreview() {
    val player = Player(0, "André", 0f, false)
    C9Theme {
        PlayerItem(player = player, deletePlayerAction = {})
    }
}