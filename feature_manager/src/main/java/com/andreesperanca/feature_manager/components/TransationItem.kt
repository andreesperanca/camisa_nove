package com.andreesperanca.feature_manager.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreesperanca.feature_manager.data.translationsList
import com.andreesperanca.feature_manager.models.Transaction
import com.andreesperanca.ui_components.theme.CamisaNoveTheme

@Composable
fun TransactionItem(
    modifier: Modifier = Modifier,
    transaction: Transaction

                    ) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(color = Color(0xFFF5F5F5))
    ) {

        Column(
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                fontSize = 16.sp,
                color = Color(0xFF1D1B20),
                text = transaction.payer,
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 13.sp,
                color = Color(0xFF49454F),
                text = transaction.payer,
            )
        }

        Text(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp),
                fontSize = 13.sp,
                color = Color(0xFF238700),
                text = transaction.value.toString(),
            )
    }
    
}

@Preview
@Composable
fun TransactionItemPreview() {
    CamisaNoveTheme() {
        TransactionItem(
            transaction = translationsList.first()
        )
    }
}