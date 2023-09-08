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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.andreesperanca.feature_manager.navigation.TabLayout
import com.andreesperanca.feature_manager.navigation.tabList
import com.andreesperanca.ui_components.theme.CamisaNoveTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

//REVIEW SUPPRESS LINTS
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun ManagerScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController) {
    val pagerState = rememberPagerState(pageCount = tabList.size)

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
            }
        },
        content = { paddingValues ->
            Surface(modifier = Modifier.padding(paddingValues)) {
                HorizontalPager(state = pagerState) { index ->
                    tabList[index].navController = navController
                    tabList[index].screen()
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ManagerScreenPreview() {
    CamisaNoveTheme {
        val navController = rememberNavController()
        ManagerScreen(navController = navController)
    }
}