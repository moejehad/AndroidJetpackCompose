package com.example.jetpackcompose.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.jetpackcompose.DetailScreen
import com.example.jetpackcompose.HomeScreen
import com.example.jetpackcompose.navigation.DETAIL_ARGUMENT_KEY
import com.example.jetpackcompose.navigation.DETAIL_ARGUMENT_KEY2
import com.example.jetpackcompose.navigation.HOME_GRAPH_ROUTE
import com.example.jetpackcompose.navigation.Screen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(DETAIL_ARGUMENT_KEY2) {
                    type = NavType.StringType
                    defaultValue = "Mohammed"
                }
            )
        ) {
            DetailScreen(navController = navController)
        }
    }
}