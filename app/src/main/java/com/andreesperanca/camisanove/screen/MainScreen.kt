package com.andreesperanca.camisanove.screen

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat.startActivity
import com.andreesperanca.feature_manager.ManagerActivity

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    context: Context
) {
    Column(modifier.fillMaxSize()) {

        TextButton(onClick = {
            Intent(context,ManagerActivity::class.java).also {
                startActivity(context, it, null)
            }
        }){

            Text(text = "Abrir manager")
        }
    }
}

@Composable
fun MainScreenPreview() {
    
}