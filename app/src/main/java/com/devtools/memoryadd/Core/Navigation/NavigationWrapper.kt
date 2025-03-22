package com.devtools.memoryadd.Core.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devtools.memoryadd.View.Home_View

class NavigationWrapper {



    /**
     * `Navigation` es una función Composable que gestiona la navegación de la aplicación.
     *
     * Define el gráfico de navegación usando NavHost de Jetpack Compose. Actualmente, solo muestra la vista `Home_View` al iniciar.
     *
     * No requiere parámetros.
     */
    @Composable
    fun Navigation() {
        val NavController = rememberNavController()

        NavHost(navController = NavController, startDestination = Home_Screen) {

            composable<Home_Screen> {

                Home_View()

            }
        }
    }


}