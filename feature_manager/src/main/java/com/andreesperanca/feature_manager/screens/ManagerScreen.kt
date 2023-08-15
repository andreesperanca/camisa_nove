package com.andreesperanca.feature_manager.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.andreesperanca.feature_manager.navigation.TabContent
import com.andreesperanca.feature_manager.navigation.TabItem
import com.andreesperanca.feature_manager.navigation.TabLayout
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

//REVIEW SUPPRESS LINTS
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun ManagerScreen(modifier: Modifier = Modifier) {

    val navController: NavHostController = rememberNavController()
    var state by remember  { mutableStateOf(0) }

    val tabList = listOf(
        TabItem.OverView,
        TabItem.Finance
    )
    var pagerState = rememberPagerState(pageCount = tabList.size)

    Scaffold(
        topBar = {
            Column(modifier = modifier) {
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

                TabLayout(tabs = tabList, pagerState = pagerState)
//                ScrollableTabRow(
//                    edgePadding = 0.dp,
//                    selectedTabIndex = state) {
//                    tabList.forEachIndexed { index, tabBarItem ->
//                        Tab(
//                            selected = state == index,
//                            onClick = { state = index },
//                            icon =  {   Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Localized description")},
//                            text = { Text(text = tabBarItem.title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
//                        )
//                    }
//                }
            }
        },
        content = {paddingValues ->
            Column(modifier = Modifier.padding(paddingValues))
            {
                TabContent(pagerState)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ManagerScreenPreview() {
    com.andreesperanca.ui_components.theme.CamisaNoveTheme {
        ManagerScreen()
    }
}