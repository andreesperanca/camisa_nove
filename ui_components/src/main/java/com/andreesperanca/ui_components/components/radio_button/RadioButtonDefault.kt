package com.andreesperanca.ui_components.components.radio_button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.CamisaNoveTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RadioButtonDefault(
    modifier: Modifier = Modifier
) {

    var isChecked = remember { mutableStateOf(true) }

    val revenueColor: Color
    val expenseColor: Color

    if (isChecked.value) {
        revenueColor = Color(0xFF90EE90)
        expenseColor = Color.Gray
    } else {
        revenueColor = Color.Gray
        expenseColor = Color(0xFFFF6B6B)
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .weight(0.5f)
                .wrapContentHeight()
                .padding(start = 16.dp),
            colors = CardDefaults.cardColors(containerColor = revenueColor),
            elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
            onClick = {
                isChecked.value = !isChecked.value
            }
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(16.dp))
            ) {
                TitleMedium(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .background(Color.Transparent),
                    text = "Receita",
                    titleColor = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Card(shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(0.5f)
                .wrapContentHeight(),
            colors = CardDefaults.cardColors(containerColor = expenseColor),
            elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
            onClick = {
                isChecked.value = !isChecked.value
            }
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues = PaddingValues(16.dp))
                    .background(Color.Transparent)
            ) {
                TitleMedium(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "Despesa",
                    titleColor = Color.White
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RadioButtonDefaultPreview() {
    CamisaNoveTheme {
        RadioButtonDefault()
    }
}
