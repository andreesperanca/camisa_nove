package com.andreesperanca.feature_balanced_team.data

import com.andreesperanca.feature_balanced_team.model.Player
import com.andreesperanca.feature_balanced_team.model.Team

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

val mockTeamList = listOf(
    Team("Andre", playerList.subList(0,3)),
    Team("Andre",playerList.subList(0,3)),
    Team("Andre",playerList.subList(0,3)),
    Team("Andre",playerList.subList(0,3)),
)