 package com.andreesperanca.ui_components.components.buttons

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.ui_components.R
import com.andreesperanca.ui_components.components.texts.SubtitleMedium
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.C9Theme

 @Composable
 fun ButtonLarge(
     modifier: Modifier = Modifier,
     onClickCta: () -> Unit,
     title: String = ""
 ) {

     Button(
         shape = RoundedCornerShape(dimensionResource(id = R.dimen.rounded_small)),
         modifier = modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
         elevation = ButtonDefaults.buttonElevation(),
         colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
         onClick = {
             onClickCta()
         })
     {

         Row(
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(PaddingValues(vertical = dimensionResource(id = R.dimen.padding_small))),
             horizontalArrangement = Arrangement.Center
         ) {
             Text(
                 modifier = Modifier,
                 style = MaterialTheme.typography.bodyLarge,
                 text = title,
                 color = MaterialTheme.colorScheme.onPrimary,
             )
         }
     }
 }


 @Composable
 fun ButtonMedium(
     modifier: Modifier = Modifier,
     onClickCta: () -> Unit,
     title: String = "Titulo botão",
     icon: Painter = painterResource(id = R.drawable.ic_settings),
     descriptionIcon: String = ""
 ) {
     Row(
         modifier = modifier
             .background(MaterialTheme.colorScheme.secondaryContainer)
             .clickable { onClickCta() }
             .padding(
                 PaddingValues(
                     vertical = dimensionResource(id = R.dimen.padding_small),
                     horizontal = 12.dp
                 )
             ),
         horizontalArrangement = Arrangement.Center
     ) {
         SubtitleMedium(
             modifier = Modifier.padding(end = 8.dp),
             color = MaterialTheme.colorScheme.onSecondaryContainer,
             text = title
         )

         Icon(
             tint = MaterialTheme.colorScheme.onSecondaryContainer,
             painter = icon,
             contentDescription = descriptionIcon
         )
     }
 }

 @Composable
 fun ButtonSmall(
     modifier: Modifier = Modifier,
     onClickCta: () -> Unit
 ) {

     var loadingState = remember { mutableStateOf(false) }

     Button(
         shape = RoundedCornerShape(4.dp),
         modifier = modifier
             .fillMaxWidth()
             .padding(horizontal = 32.dp)
         ,
         elevation = ButtonDefaults.buttonElevation(),
         colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
         onClick = {
             loadingState.value = !loadingState.value
             onClickCta()
         } )
     {
         if(loadingState.value) {
             CircularProgressIndicator(color = Color.White)
         } else {
             TitleMedium(
                 titleColor = Color.White,
                 modifier = Modifier.padding(PaddingValues(8.dp)),
                 text = "Create Transaction"
             )
         }
     }
 }


@Preview
@Composable
fun DefaultButtonPreview() {
    C9Theme {
        ButtonMedium(onClickCta = {})
    }
}