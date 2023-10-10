package com.andreesperanca.ui_components.components.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HeaderLarge(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface,
        text = text,
        style = MaterialTheme.typography.headlineMedium
    )
}