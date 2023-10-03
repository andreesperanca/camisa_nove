package com.andreesperanca.ui_components.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.andreesperanca.ui_components.R

@Composable
fun HighlightsCardView() {
    Card(
        shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.image),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            )
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                style = MaterialTheme.typography.titleSmall,
                text = "Organize & gerencie"
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                style = MaterialTheme.typography.bodySmall,
                text = "Gerencie lista de espera, pagamento e divisão de equipes em um só lugar")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
               Button(
                   modifier = Modifier
                       .align(Alignment.BottomEnd)
                       .padding(end = 8.dp),
                   onClick = { /*TODO*/ },
               ) {
                   Text(text = "Começar")
               }
            }
        }
    }
}