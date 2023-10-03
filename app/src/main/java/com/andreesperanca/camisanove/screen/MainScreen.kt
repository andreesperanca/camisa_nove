package com.andreesperanca.camisanove.screen

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.andreesperanca.camisanove.R
import com.andreesperanca.feature_manager.ManagerActivity
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
                title = { Text(text = stringResource(id = R.string.app_name)) },
                navigationIcon = {
                    Icon(painter = painterResource(id = drawable.baseline_arrow_back_24),
                        contentDescription = "Detalhes")
                    },
                actions = {
                    Icon(painter = painterResource(id = drawable.baseline_arrow_back_24),
                    contentDescription = "Detalhes") }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 32.dp),
                style = MaterialTheme.typography.titleMedium,
                text = "Novidades"
            )
            HighlightsCardView()
        }
    }

//    Column(modifier.fillMaxSize()) {
//
//        TextButton(onClick = {
//            Intent(context,ManagerActivity::class.java).also {
//                startActivity(context, it, null)
//            }
//        }){
//    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    C9Theme {
        MainScreen()
    }
}