package com.andreesperanca.feature_manager.screens.finance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.andreesperanca.ui_components.theme.CamisaNoveTheme

@Composable
fun CreateFinanceScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
        .fillMaxSize()
    ) {


    }

}

@Preview(showBackground = true)
@Composable
fun CreateFinanceScreenPreview() {
    CamisaNoveTheme {
        CreateFinanceScreen()
    }
}