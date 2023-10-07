package com.andreesperanca.feature_balanced_team.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.andreesperanca.feature_balanced_team.R
import com.andreesperanca.feature_balanced_team.model.Player
import com.andreesperanca.ui_components.components.texts.SubtitleMedium
import com.example.compose.md_theme_light_surfaceContainer

@Composable
fun PlayerItem(player: Player) {

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
            SubtitleMedium(
                text = player.name,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}