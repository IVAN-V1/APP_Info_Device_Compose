package com.devtools.memoryadd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.devtools.memoryadd.Core.Navigation.NavigationWrapper
import com.devtools.memoryadd.ui.theme.MemoryAddTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            MemoryAddTheme {

// Navega a la pantalla apropiada según el estado actual
                NavigationWrapper().Navigation()
            }

        }
    }
}



