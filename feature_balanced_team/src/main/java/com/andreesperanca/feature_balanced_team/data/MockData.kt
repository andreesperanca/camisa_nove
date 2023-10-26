package com.andreesperanca.feature_balanced_team.data

import com.andreesperanca.feature_balanced_team.model.Player
import com.andreesperanca.database.model.Team

val playerList = listOf(
    com.andreesperanca.database.model.Player(uid = 0,"Andre", level = 0F, isSpecialPLayer = false)
    )

val mockTeamList = mutableListOf<Team>(
   Team(
       "",
       playerList as MutableList
   )
)