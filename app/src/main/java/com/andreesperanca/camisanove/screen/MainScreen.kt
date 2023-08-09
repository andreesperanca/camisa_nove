package com.andreesperanca.camisanove.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.feature_manager.screens.OverViewContent
import com.andreesperanca.ui_components.theme.CamisaNoveTheme

//REVIEW SUPPRESS LINTS
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Column() {
                TopAppBar(
                    title = {
                        Text(
                            "Amigos do André",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                )
                var state by remember  { mutableStateOf(0) }
                val titles = listOf("Tab 1", "Tab 2", "Tab 3", "Tab 3", "Tab 3", "Tab 3","Tab 3")
                ScrollableTabRow(
                    edgePadding = 0.dp,
                    selectedTabIndex = state) {
                    titles.forEachIndexed { index, title ->
                        Tab(
                            selected = state == index,
                            onClick = { state = index },
                            icon =  {   Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Localized description")},
                            text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                        )
                    }
                }
            }
        },
        content = {
            OverViewContent()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    com.andreesperanca.ui_components.theme.CamisaNoveTheme {
        MainScreen()
    }
}