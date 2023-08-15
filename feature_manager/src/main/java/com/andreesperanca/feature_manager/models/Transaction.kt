package com.andreesperanca.feature_manager.models

data class Transaction(
    val id: Long,
    val value: Float,
    val payer: String, // TODO: CHANGE TO USER OBJECT
    val description: String,
    val type: TransactionType
)

enum class TransactionType {
    INCOME,
    EXPENSE
}

