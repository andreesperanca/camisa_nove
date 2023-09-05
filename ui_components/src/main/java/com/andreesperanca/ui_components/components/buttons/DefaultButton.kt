package com.andreesperanca.ui_components.components.buttons

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.CamisaNoveTheme

@Composable
fun DefaultButton(modifier: Modifier = Modifier) {
    OutlinedButton(
        modifier = modifier,
        shape = Shapes().extraSmall,
        onClick = {

        },

    ) {
        TitleMedium(text = "Confirmar")

    }
}

@Preview
@Composable
fun DefaultButtonPreview() {
    CamisaNoveTheme {
        DefaultButton()
    }
}