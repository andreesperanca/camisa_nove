package com.andreesperanca.feature_manager.screens.finance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.ui_components.theme.CamisaNoveTheme


@Composable
fun BottomSheetCreateFinance(modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        var value by remember { mutableStateOf("") }
        var valuePassword by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = value,
            onValueChange = {
                value = it
            },
            label = { Text(text = "Title") },
            placeholder = { Text(text = "Enter with title") },
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = value,
            onValueChange = {
                value = it
            },
            label = { Text(text = "Subtitle") },
            placeholder = { Text(text = "Enter with subtitle") },
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = value,
            onValueChange = {
                value = it
            },
            label = { Text(text = "Value") },
            placeholder = { Text(text = "Enter with value") },
        )


    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetCreateFinancePreview() {
    CamisaNoveTheme() {
        BottomSheetCreateFinance()
    }
}