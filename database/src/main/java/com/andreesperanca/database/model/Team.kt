package com.andreesperanca.database.model

data class Team(
    val name: String,
    val players: MutableList<Player>
) {
    fun calculatePoints() : Float {
        var totalPoints = 0.0f
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
