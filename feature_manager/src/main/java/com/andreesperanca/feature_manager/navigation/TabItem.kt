package com.andreesperanca.feature_manager.navigation

import androidx.compose.runtime.Composable
import com.andreesperanca.feature_manager.screens.FinanceContent
import com.andreesperanca.feature_manager.screens.OverViewContent

typealias ComposableFun = @Composable () -> Unit
sealed class TabItem(
    var icon: Int,
    val title: String,
    var screen: ComposableFun
) {

    object OverView: TabItem(
        title = "OverView",
        icon = 2,
        screen = { OverViewContent() }
    )

    object Finance: TabItem(
        title = "Finanças",
        icon = 1,
        screen =  { FinanceContent() }
    )
}