package com.andreesperanca.ui_components.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleMedium(
    modifier: Modifier = Modifier,
    text: String) {
    Text(
        modifier = modifier,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        color = Color(0xFF1D1B20),
        text = text)
}