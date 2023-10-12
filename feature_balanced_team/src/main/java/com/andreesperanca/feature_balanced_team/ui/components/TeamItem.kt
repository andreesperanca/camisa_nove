package com.andreesperanca.feature_balanced_team.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.andreesperanca.feature_balanced_team.R
import com.andreesperanca.feature_balanced_team.data.mockTeamList
import com.andreesperanca.feature_balanced_team.model.Team
import com.andreesperanca.ui_components.components.texts.DescriptionMedium
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.C9Theme

@Composable
fun TeamItem(team: Team) {
    Column() {
        TitleMedium(
            modifier = Modifier
                .padding(
                    top = dimensionResource(id = R.dimen.padding_small),
                    start = dimensionResource(
                        id = R.dimen.padding_medium
                    )
                )
                .fillMaxWidth(),
            text = stringResource(id = R.string.feature_balanced_team_name)
        )

        DescriptionMedium(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(R.dimen.padding_medium),
                    end = dimensionResource(R.dimen.padding_medium)
                ),
            text = stringResource(R.string.feature_balanced_team_description)
        )

        Column(
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_medium),
                    end = dimensionResource(id = R.dimen.padding_medium)
                ),
            content = {
                team.players.forEach {
                    Text(


                        text = it.name)
                }
            })
    }
}

@Preview(showBackground = true)
@Composable
fun TeamItemPreview() {
    C9Theme {
        TeamItem(team = mockTeamList.first())
    }
}