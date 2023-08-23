package com.andreesperanca.feature_manager.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreesperanca.feature_manager.R
import com.andreesperanca.ui_components.theme.CamisaNoveTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersContent() {



    var expanded by remember { mutableStateOf (false) }
    val enterTransition = remember {
        expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(500)
        ) + fadeIn(initialAlpha = .3f, animationSpec = tween(500))
    }

    val exitTransition = remember {
        shrinkVertically(
            shrinkTowards = Alignment.Top,
            animationSpec = tween(500)
        ) + fadeOut(animationSpec = tween(500))
    }

    var minLinesDescription = if(expanded) 2 else 1

    Scaffold(
        content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
        ) {
            Surface(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable {
                    expanded = !expanded
                }
                , color = MaterialTheme.colorScheme.inverseOnSurface
            ) {
                Column(
                    modifier = Modifier
                        .heightIn(min = 56.dp)
                        .padding(PaddingValues(16.dp, 8.dp)),
                    content = {
                        Row() {
                            Image(
                                modifier = Modifier
                                    .size(width = 80.dp, height = 80.dp)
                                    .clip(CircleShape),
                                painter = painterResource(id = R.drawable.img),
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )

                            Column(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(start = 12.dp)
                            ) {
                                Text(
                                    text = "Neymar Júnior",
                                    fontSize = 16.sp,
                                    overflow = TextOverflow.Ellipsis,
                                    color = Color(0xFF1D1B20),
                                    fontWeight = FontWeight.Medium,
                                    maxLines = 1,
                                )
                                Text(
                                    text = "Jogador caro e com muita vontade de fazer gol, não me dê espaço se não eu lhe meto gol",
                                    fontSize = 13.sp,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = minLinesDescription
                                )
                            }
                        }

                        AnimatedVisibility(
                            visible = expanded,
                            enter = enterTransition,
                            exit = exitTransition
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.CenterHorizontally)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .align(Alignment.CenterStart)
                                        .padding(top = 8.dp)
                                ) {
                                    Text(text = "Avaliação do Jogador",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color(0xFF1D1B20)
                                    )
                                    Row(
                                        modifier = Modifier.padding(top = 8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        for (i in 1..5) {
                                            val starIcon = if (i <= 5) {
                                                Icons.Default.Star
                                            } else {
                                                Icons.Default.Add
                                            }
                                            Icon(
                                                imageVector = starIcon,
                                                contentDescription = null, // Optional content description
                                                modifier = Modifier.size(24.dp)
                                            )
                                        }
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(top = 8.dp)
                                ) {
                                    Text(
                                        text = "Posição:",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color(0xFF1D1B20),
                                        overflow = TextOverflow.Ellipsis,
                                        maxLines = 1,
                                    )
                                    Spacer(modifier = Modifier.padding(start = 2.dp))

                                    Text(
                                        text = "ATA",
                                        fontSize = 16.sp,
                                        overflow = TextOverflow.Ellipsis,
                                        maxLines = 1,
                                    )
                                }
                            }
                        }
                    }
                )
            }
        }

    },
        bottomBar = {
//        BottomAppBar(
//            actions = {
//                IconButton(onClick = { /* doSomething() */ }) {
//                    Icon(Icons.Filled.Check, contentDescription = "Localized description")
//                }
//                IconButton(onClick = { /* doSomething() */ }) {
//                    Icon(
//                        Icons.Filled.Edit,
//                        contentDescription = "Localized description",
//                    )
//                }
//            },
//            floatingActionButton = {
//                FloatingActionButton(
//                    onClick = { /* do something */ },
//                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
//                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
//                ) {
//                    Icon(Icons.Filled.Add, "Localized description")
//                }
//            }
//        )
    })
}

@Preview(showBackground = true)
@Composable
fun PlayersContentPreview() {
    CamisaNoveTheme() {
        PlayersContent()
    }
}