package com.andreesperanca.ui_components.components.buttons

import android.widget.ProgressBar
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.ui_components.components.texts.TitleMedium
import com.andreesperanca.ui_components.theme.CamisaNoveTheme

@Composable
fun DefaultButton(
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
    CamisaNoveTheme {
        DefaultButton(onClickCta = {})
    }
}