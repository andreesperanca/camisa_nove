package com.andreesperanca.feature_balanced_team.data

import com.andreesperanca.feature_balanced_team.model.Player
import com.andreesperanca.database.model.Team
import java.math.BigDecimal

val playerList = listOf(
    com.andreesperanca.database.model.Player(uid = 0,"Andre", level = BigDecimal(0.0), isSpecialPLayer = false),
    com.andreesperanca.database.model.Player(uid = 0,"Andre", level = BigDecimal(0.0), isSpecialPLayer = false),
    com.andreesperanca.database.model.Player(uid = 0,"Andre", level = BigDecimal(0.0), isSpecialPLayer = false)
    )

val mockTeamList = mutableListOf<Team>(
   Team(
       "Time1",
       playerList as MutableList
   )
)