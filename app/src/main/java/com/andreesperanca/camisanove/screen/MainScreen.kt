package com.andreesperanca.camisanove.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.camisanove.R
import com.andreesperanca.ui_components.R.*
import com.andreesperanca.ui_components.components.cards.HighlightsCardView
import com.andreesperanca.ui_components.theme.C9Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
//    context: Context
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFEFEDF1)
                ),
                title = { Text(
                    color = MaterialTheme.colorScheme.primary,
                    text = stringResource(id = R.string.app_name)) },
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(PaddingValues(8.dp)),
                        tint = Color(0xFF45464F),
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = stringResource(id = R.string.app_main_screen_menu))
                    },
                actions = {
                    Icon(
                        modifier = Modifier.padding(PaddingValues(8.dp)),
                        tint = Color(0xFF45464F),
                        painter = painterResource(id = R.drawable.ic_account),
                    contentDescription = stringResource(id = R.string.app_main_screen_my_account))
                }
            )
        }
    ) {
        Column(modifier =
        Modifier
            .padding(it)
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color(0xFFFBF8FD))

        ) {
            Spacer(modifier = Modifier.padding(top = 32.dp))
            HighlightsCardView(

                image = painterResource(id = drawable.image),
                title = "Times equilibrados",
                description = "Times equilibrados",
                ctaTitle = "Começar",
                clickCta = {},
                imageDescription = "Times equilibrados"
            )



        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    C9Theme {
        MainScreen()
    }
}