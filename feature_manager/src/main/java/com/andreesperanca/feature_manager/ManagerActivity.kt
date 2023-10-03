package com.andreesperanca.feature_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.andreesperanca.feature_manager.navigation.FeatureManagerNavHost
import com.andreesperanca.ui_components.theme.C9Theme

class ManagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            C9Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navHostController = rememberNavController()
                    FeatureManagerNavHost(navController = navHostController)
                }
            }
        }
    }
}