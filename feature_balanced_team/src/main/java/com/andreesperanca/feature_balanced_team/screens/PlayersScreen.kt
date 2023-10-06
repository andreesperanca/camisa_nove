package com.andreesperanca.feature_balanced_team.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreesperanca.feature_balanced_team.R
import com.andreesperanca.feature_balanced_team.model.Player
import com.andreesperanca.ui_components.components.texts.DescriptionMedium
import com.andreesperanca.ui_components.components.texts.SubtitleMedium
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.C9Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersScreen(modifier: Modifier = Modifier) {

    val playerList = listOf(
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),
        Player("Andre"),

    )

    Box(modifier = Modifier
        .fillMaxSize()
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFFFBF8FD))
                .align(Alignment.TopCenter)
        ) {

            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFEFEDF1)
                ),
                title = {
                    TitleMedium(text = "Equilibrar equipes")
                },
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(PaddingValues(8.dp)),
                        tint = Color(0xFF45464F),
                        painter = painterResource(id = com.google.android.material.R.drawable.ic_arrow_back_black_24),
                        contentDescription = "Botão voltar")
                }
            )

            SecondaryButton(modifier = Modifier.padding(
                top = 32.dp,
                start = 16.dp
            ))



            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            ) {

                Box(modifier = Modifier) {

                    TitleMedium(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.feature_balanced_players, playerList.size.toString())
                    )
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterEnd),
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = ""
                    )
                }
            }

            DescriptionMedium(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                text = "Futebol dos amigos do André para se divertir muito com a pelada doida."
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




        Button(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .align(Alignment.BottomCenter),
            onClick = { },
        ) {

            Text(
                modifier = Modifier.padding(PaddingValues(8.dp)),
                text = "DIVIDIR EQUIPES")
        }
    }
}

@Composable
fun PlayerItem(player: Player) {

    Surface(
        modifier = Modifier
            .background(Color(0xFFFBF8FD))
            .heightIn(50.dp)
            .padding(
                bottom = 8.dp, top = 8.dp,
                start = 16.dp, end = 16.dp
            )
    ) {
        Row(
            modifier = Modifier
                .background(Color(0xFFEFEDF1))
                .fillMaxWidth()
                .padding(PaddingValues(18.dp))
        ) {
            Text(
                fontSize = 16.sp,
                text = player.name)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PlayersScreenPreview() {
    C9Theme {
        PlayersScreen ()
    }
}

@Composable
fun SecondaryButton(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Color(0xFFFFDCC7))
            .padding(PaddingValues(vertical = 8.dp, horizontal = 12.dp)),
        horizontalArrangement = Arrangement.Center
    ) {
        SubtitleMedium(
            modifier = Modifier.padding(end = 8.dp),
            color = Color(0xFF311300),
            text = "Configurações"
        )

        Icon(
            tint = Color(0xFF311300),
            painter = painterResource(id = R.drawable.ic_settings),
            contentDescription = "Botão voltar"
        )
    }
}