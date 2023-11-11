package com.andreesperanca.database.model

import java.math.BigDecimal

data class Team(
    val name: String,
    val players: MutableList<Player>
) {
    fun calculatePoints() : BigDecimal {
        var totalPoints = BigDecimal.ZERO
        for (player in players) {
            totalPoints += player.level
        }
        return totalPoints
    }

    fun formattedPoints(): String {
        val points = calculatePoints()
        return String.format("%.1f", points)
    }

}
