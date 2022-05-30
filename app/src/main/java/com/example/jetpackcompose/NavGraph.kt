package com.example.jetpackcompose

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAILS_ARGUMENT_KEY){
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(DETAILS_ARGUMENT_NAME){
                    type = NavType.StringType
                }
            )
        ){
            Log.e("args",it.arguments?.getInt(DETAILS_ARGUMENT_KEY).toString())
            Log.e("args",it.arguments?.getString(DETAILS_ARGUMENT_NAME).toString())
            DetailScreen(navController = navController)
        }
    }
}