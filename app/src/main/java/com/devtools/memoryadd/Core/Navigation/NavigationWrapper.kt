package com.devtools.memoryadd.Core.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devtools.memoryadd.View.Home_View

class NavigationWrapper {


@Composable
fun Navigation() {


val NavController = rememberNavController()


    NavHost(navController = NavController, startDestination = Initial_Page){

        composable<Initial_Page> {

          Home_View(

          )

        }


    }


}




}