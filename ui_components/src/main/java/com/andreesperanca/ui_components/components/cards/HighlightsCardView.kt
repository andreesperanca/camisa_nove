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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.ui_components.R
import com.andreesperanca.ui_components.theme.C9Theme

@Composable
fun HighlightsCardView(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    ctaTitle: String,
    clickCta: () -> Unit,
    image: Painter,
    imageDescription: String
) {
    Card(
        shape = RectangleShape,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEFEDF1))
    ) {
        Column(modifier = Modifier) {
//            Image(
//                painter = image,
//                contentScale = ContentScale.Crop,
//                contentDescription = imageDescription,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(100.dp)
//            )
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp),
                style = MaterialTheme.typography.titleSmall,
                color = Color(0xFF1B1B1F),
                text = title
            )
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                color = Color(0xFF45464F),
                style = MaterialTheme.typography.bodySmall,
                text = description)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
               Button(
                   modifier = Modifier
                       .align(Alignment.BottomEnd)
                       .padding(end = 8.dp, bottom = 8.dp, top = 8.dp),
                   onClick = { clickCta() },
               ) {
                   Text(text = ctaTitle)
               }
            }
        }
    }
}

@Preview
@Composable
fun HighlightsCardViewPreview() {
    C9Theme {
        HighlightsCardView(
            modifier = Modifier,
            title = "",
            description = "",
            ctaTitle = "",
            clickCta = {},
            image = painterResource(id = R.drawable.image),
            imageDescription = ""
        )
    }
}