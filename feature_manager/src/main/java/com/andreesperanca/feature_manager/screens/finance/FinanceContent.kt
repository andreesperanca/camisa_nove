package com.andreesperanca.feature_manager.screens.finance

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreesperanca.feature_manager.components.TransactionItem
import com.andreesperanca.feature_manager.data.translationsList
import com.andreesperanca.feature_manager.navigation.TabItem
import com.andreesperanca.feature_manager.navigation.tabList
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.CamisaNoveTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun FinanceContent(modifier: Modifier = Modifier) {

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )

    val coroutineScope = rememberCoroutineScope()

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetElevation = 8.dp,
        sheetGesturesEnabled = true,
        sheetShape = RoundedCornerShape(
            bottomStart = 0.dp,
            bottomEnd = 0.dp,
            topStart = 16.dp,
            topEnd = 16.dp
        ),
        sheetContent = {
            BottomSheetCreateFinance(closeClick = {
                coroutineScope.launch {
                    sheetState.hide()
                }
            })
        }
    ) {
        Column(modifier = modifier.fillMaxSize()) {

            TitleMedium(
                modifier = Modifier.padding(start = 16.dp, top = 32.dp),
                text = "Conta"
            )

            Text(
                modifier = Modifier.padding(start = 16.dp, bottom = 32.dp),
                text = "R$ 20,00",
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

                    TitleMedium(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp),
                        text = "Transações recentes")

                    Surface( modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 8.dp)
                        .clickable {
                            tabList.filter { it == TabItem.Finance }.first().apply {
                                navController?.navigate(
                                    "create_finance_screen")
                            }

                            tabList.indexOf(TabItem.Finance)
//                            coroutineScope.launch {
//                                if (sheetState.isVisible) sheetState.hide()
//                                else sheetState.show()
//                            }


                        }) {
                        Icon(
                            modifier = Modifier.padding(PaddingValues(8.dp)),
                            imageVector = Icons.Filled.Add, contentDescription = "")
                    }
                }
            }
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
}
@Preview(showBackground = true)
@Composable
fun FinanceContentPreview() {
    CamisaNoveTheme {
        FinanceContent()
    }
}