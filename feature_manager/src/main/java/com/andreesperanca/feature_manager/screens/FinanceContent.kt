package com.andreesperanca.feature_manager.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreesperanca.feature_manager.components.TransactionItem
import com.andreesperanca.feature_manager.data.translationsList
import com.andreesperanca.ui_components.theme.CamisaNoveTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinanceContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 32.dp),
            text = "Conta",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )

        Text(
            modifier = Modifier.padding(start = 16.dp, bottom = 32.dp),
            text = "R\$ 20,00",
            fontSize = 36.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        ElevatedAssistChip(
            modifier = Modifier.padding(start = 16.dp) ,
            label = {
                    Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Box() {
                            Icon(
                                modifier = Modifier.align(Alignment.CenterStart),
                                imageVector = Icons.Filled.Person, contentDescription = ""
                            )
                        }
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = "Payment Pix"
                        )
                    }
            }, onClick = {})

        Row(modifier = Modifier
            .padding(top = 32.dp)) {
            Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF1D1B20),
                text = "Transações recentes")

                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.dp),
                    imageVector = Icons.Filled.Add, contentDescription = ""
                )

            }
        }

        Text(
            modifier = Modifier
                .padding(start = 16.dp),
            fontSize = 13.sp,
            color = Color(0xFF49454F),
            text ="Vizualizar histórico completo")

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            contentPadding = PaddingValues(all = 16.dp),

        ) {
            itemsIndexed(translationsList) { index, transaction ->
                TransactionItem(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    transaction = transaction)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FinanceContentPreview() {
    CamisaNoveTheme {
        FinanceContent()
    }
}