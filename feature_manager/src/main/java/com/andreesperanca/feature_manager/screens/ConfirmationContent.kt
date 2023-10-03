package com.andreesperanca.feature_manager.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreesperanca.feature_manager.data.playersList
import com.andreesperanca.ui_components.theme.C9Theme


@Composable
fun ConfirmationContent(modifier: Modifier = Modifier) {

    var expandedConfirmados by remember { mutableStateOf(false) }
    var expandedPendentes by remember { mutableStateOf(false) }
    var expandedRecusados by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
    ) {

        Card(
            modifier
                .fillMaxWidth()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)
                .clickable {
                    expandedConfirmados = !expandedConfirmados
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(PaddingValues(vertical = 16.dp, horizontal = 8.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, end = 16.dp)
                ) {

                    Text(
                        modifier = Modifier.align(Alignment.CenterStart),
                        text = "Confirmados"
                    )

                    Icon(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        imageVector = Icons.Default.Add,
                        contentDescription = ""
                    )
                }
            }

            AnimatedVisibility(visible = expandedConfirmados) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(vertical = 16.dp, horizontal = 8.dp))
                ) {
                    LazyColumn {
                        items(playersList) { player ->
                            Text(text = player.name)
                        }
                    }
                }
            }
        }


        Card(
            modifier
                .fillMaxWidth()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)
                .clickable {
                    expandedPendentes = !expandedPendentes
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(PaddingValues(vertical = 16.dp, horizontal = 8.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, end = 16.dp)
                ) {

                    Text(
                        modifier = Modifier.align(Alignment.CenterStart),
                        text = "Pendentes"
                    )

                    Icon(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        imageVector = Icons.Default.Add,
                        contentDescription = ""
                    )
                }
            }

            AnimatedVisibility(visible = expandedPendentes) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(vertical = 16.dp, horizontal = 8.dp))
                ) {
                    LazyColumn {
                        items(playersList) { player ->
                            Text(text = player.name)
                        }
                    }
                }
            }
        }


        Card(
            modifier
                .fillMaxWidth()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)
                .clickable {
                    expandedRecusados = !expandedRecusados
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(PaddingValues(vertical = 16.dp, horizontal = 8.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, end = 16.dp)
                ) {

                    Text(
                        modifier = Modifier.align(Alignment.CenterStart),
                        text = "Recusados"
                    )

                    Icon(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        imageVector = Icons.Default.Add,
                        contentDescription = ""
                    )
                }
            }

            AnimatedVisibility(visible = expandedRecusados) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(vertical = 16.dp, horizontal = 8.dp))
                ) {
                    LazyColumn {
                        items(playersList) { player ->
                            Text(text = player.name)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SegmentedControl(
    modifier: Modifier = Modifier,
    items: List<String>,
    defaultSelectedItemIndex: Int = 0,
    useFixedWidth: Boolean = false,
    itemWidth: Dp = 120.dp,
    cornerRadius: Int = 24,
    onItemSelection: (selectedItemIndex: Int) -> Unit
) {
    val selectedIndex = remember { mutableStateOf(defaultSelectedItemIndex) }
    val itemIndex = remember { mutableStateOf(defaultSelectedItemIndex) }

    Surface(
        modifier = modifier

            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 16.dp, horizontal = 8.dp)),
//            CardDefaults.cardColors(
//                containerColor = if (selectedIndex.value == itemIndex.value) {
//
//                    MaterialTheme.colorScheme.background
//                } else {
//
//                    MaterialTheme.colorScheme.secondary
//                }
//            )
//            shape = RoundedCornerShape(cornerRadius)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
//                    .background(MaterialTheme.colorScheme.secondary)
                ,
                horizontalArrangement = Arrangement.Center
            ) {
                items.forEachIndexed { index, item ->
                    itemIndex.value = index
                    Card(
                        modifier = modifier
                            .weight(1f)
                            .heightIn(max = 48.dp)
                            .padding(2.dp),
                        onClick = {
                            selectedIndex.value = index
                            onItemSelection(selectedIndex.value)
                        },
                        colors = CardDefaults.cardColors(
                            containerColor = if (selectedIndex.value == index) {
                                MaterialTheme.colorScheme.background
                            } else {
                                MaterialTheme.colorScheme.secondary
                            },
                            contentColor = if (selectedIndex.value == index)
                                MaterialTheme.colorScheme.scrim
                            else
                                MaterialTheme.colorScheme.onSecondary
                        ),
                        shape = when (index) {
                            0 -> RoundedCornerShape(
                                topStartPercent = cornerRadius,
                                topEndPercent = cornerRadius,
                                bottomStartPercent = cornerRadius,
                                bottomEndPercent = cornerRadius
                            )

                            items.size - 1 -> RoundedCornerShape(
                                topStartPercent = cornerRadius,
                                topEndPercent = cornerRadius,
                                bottomStartPercent = cornerRadius,
                                bottomEndPercent = cornerRadius
                            )

                            else -> RoundedCornerShape(
                                topStartPercent = 0,
                                topEndPercent = 0,
                                bottomStartPercent = 0,
                                bottomEndPercent = 0
                            )
                        },
                    ) {
                        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(
                                text = item,
                                style = LocalTextStyle.current.copy(
                                    fontSize = 14.sp,
                                    fontWeight = if (selectedIndex.value == index)
                                        LocalTextStyle.current.fontWeight
                                    else
                                        FontWeight.Normal,
                                    color = if (selectedIndex.value == index)
                                        MaterialTheme.colorScheme.scrim
                                    else
                                        MaterialTheme.colorScheme.onSecondary
                                ),
                                textAlign = TextAlign.Center,

                                )
                        }
                    }
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun ConfirmationContentPreview() {
    C9Theme {
        ConfirmationContent()
    }
}