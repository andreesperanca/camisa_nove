package com.andreesperanca.ui_components.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DescriptionMedium(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(modifier = modifier,
        fontSize = 16.sp,
        color = Color(0xFF49454F),
        text = text
    )
}

@Composable
fun DescriptionSubtitleMedium(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(modifier = modifier,
        fontSize = 14.sp,
        color = Color(0xFF49454F),
        text = text
    )
}