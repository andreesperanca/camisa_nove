package com.andreesperanca.feature_manager.data

import com.andreesperanca.feature_manager.models.Transaction
import com.andreesperanca.feature_manager.models.TransactionType

val translationsList = listOf(
    Transaction(
        id = 1L, value = 18F, payer = "André", description = "Olá", type = TransactionType.EXPENSE
    ),
    Transaction(
        id = 1L, value = 18F, payer = "André", description = "Olá", type = TransactionType.EXPENSE
    )
)