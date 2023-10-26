package com.andreesperanca.database.model

data class Team(
    val name: String,
    val players: MutableList<Player>
)
