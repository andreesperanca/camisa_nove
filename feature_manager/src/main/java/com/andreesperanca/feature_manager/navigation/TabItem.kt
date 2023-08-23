package com.andreesperanca.feature_manager.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.andreesperanca.feature_manager.screens.ConfirmationContent
import com.andreesperanca.feature_manager.screens.FinanceContent
import com.andreesperanca.feature_manager.screens.OverViewContent
import com.andreesperanca.feature_manager.screens.PlayersContent
import com.andreesperanca.feature_manager.screens.TimerContent

typealias ComposableFun = @Composable () -> Unit
sealed class TabItem(
    var icon: ImageVector,
    val title: String,
    var screen: ComposableFun
) {

    object OverView: TabItem(
        title = "Overview",
        icon = Icons.Filled.Info,
        screen = { OverViewContent() }
    )

    object Finance: TabItem(
        title = "Finance",
        icon = Icons.Filled.Info,
        screen =  { FinanceContent() }
    )

    object Players: TabItem(
        title = "Players",
        icon = Icons.Filled.Info,
        screen =  { PlayersContent() }
    )
    object Confirmation: TabItem(
        title = "Confirmation",
        icon = Icons.Filled.Info,
        screen = { ConfirmationContent() }
    )
    object Timer: TabItem(
        title = "Timer",
        icon = Icons.Filled.Info,
        screen = { TimerContent() }
    )
}