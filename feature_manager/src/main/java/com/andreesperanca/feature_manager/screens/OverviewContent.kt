package com.andreesperanca.feature_manager.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreesperanca.feature_manager.R
import com.andreesperanca.ui_components.theme.CamisaNoveTheme

@Composable
fun OverViewContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = 32.dp, bottom = 32.dp)
            .verticalScroll(state = rememberScrollState()))
    {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.ic_test), contentDescription = "Group image")

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF1D1B20),
            text = "Amigos do André")

        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
            fontSize = 16.sp,
            color = Color(0xFF49454F),
            text = "Futebol dos amigos do André para se divertir muito com a pelada doida.")

        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF1D1B20),
            text = "Local")

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.ic_test), contentDescription = "Group image")


        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF1D1B20),
            text = "Regras")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp),
            horizontalArrangement = Arrangement.Center,
            ) {
            Text(modifier = Modifier,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF1D1B20),
                text = "Download aqui")

            Icon(
                modifier = Modifier.padding(start = 4.dp),
                painter = painterResource(id = R.drawable.ic_test), contentDescription = "icon donwlaod")
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF1D1B20),
            text = "Data")

        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            fontSize = 16.sp,
            color = Color(0xFF49454F),
            text = "Todos aos sábados")

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF1D1B20),
            text = "Valores")

        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
            fontSize = 16.sp,
            color = Color(0xFF49454F),
            text = "Avulsos: R\$ 15,00")
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
            fontSize = 16.sp,
            color = Color(0xFF49454F),
            text = "Mensalistas: R\$450,00")
    }
}


@Preview(showBackground = true)
@Composable
fun OverViewContentPreview() {
    CamisaNoveTheme {
        OverViewContent()
    }
}