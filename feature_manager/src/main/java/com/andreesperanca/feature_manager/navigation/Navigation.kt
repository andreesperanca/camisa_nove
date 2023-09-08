package com.andreesperanca.feature_manager.navigation


import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.andreesperanca.feature_manager.screens.ConfirmationContent
import com.andreesperanca.feature_manager.screens.ManagerScreen
import com.andreesperanca.feature_manager.screens.PlayersContent
import com.andreesperanca.feature_manager.screens.TimerContent
import com.andreesperanca.feature_manager.screens.finance.CreateFinanceScreen
import com.andreesperanca.feature_manager.screens.finance.FinanceContent
import com.andreesperanca.feature_manager.screens.overview.OverViewContent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch

@Composable
fun FeatureManagerNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "feature_manager"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,

    ) {

        navigation(startDestination = "manager_screen", "feature_manager") {
            composable("manager_screen") {
                ManagerScreen(navController = navController)
            }
            composable("create_finance_screen",
                enterTransition = {
                    slideIntoContainer(
                        animationSpec = tween(300, easing = EaseIn),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                }
            ) {
                CreateFinanceScreen()
            }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(tabs: List<TabItem>, pagerState: PagerState) {

    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        edgePadding = 0.dp,
        selectedTabIndex = pagerState.currentPage
    ) {
        tabs.forEachIndexed { index, tabBarItem ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                icon = { Icon(imageVector = tabBarItem.icon, contentDescription = "Localized description") },
                text = { Text(text = tabBarItem.title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
            )
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { index ->
        when (index) {
            0 -> { OverViewContent() }
            1 -> { FinanceContent() }
            2 -> { PlayersContent() }
            3 -> { ConfirmationContent() }
            4 -> { TimerContent() }
        }
    }
}

val tabList = listOf(
    TabItem.OverView,
    TabItem.Finance,
    TabItem.Players,
    TabItem.Confirmation,
    TabItem.Timer
)
