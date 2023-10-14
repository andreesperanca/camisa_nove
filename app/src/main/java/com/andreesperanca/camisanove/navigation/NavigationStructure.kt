package com.andreesperanca.camisanove.navigation

import com.andreesperanca.feature_balanced_team.navigation.TeamBalancedFeatureGraph

object AppGraph {
    val home = HomeGraph
    val teams_balanced = TeamBalancedFeatureGraph
}
object HomeGraph {
    const val ROOT = "HOME_GRAPH"
    const val HOME = "HOME"
}
object RootGraph {
    const val ROOT = "root_graph"
}