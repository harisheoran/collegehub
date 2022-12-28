package com.example.collegehub.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.collegehub.R
import com.example.collegehub.data.DepartmentList

import com.example.collegehub.ui.semesters.SemesterMainScreen

enum class MainRoutes{
    Home,
    Details
}

@Composable
fun MainScreen(){
    val navController: NavHostController = rememberNavController()
    var departmentList = DepartmentList.deptsList
    NavHost(navController = navController,
        startDestination = MainRoutes.Home.name,
        modifier = Modifier
        ){

        // Home Screen
        composable(route = MainRoutes.Home.name){
            Home(list = departmentList,navController)
        }

        // Each Department

        composable(route = "${MainRoutes.Details.name}/{id}/{name}",
            arguments = listOf(navArgument("id") {type = NavType.IntType})
        ){
            SemesterMainScreen(departmentList,it.arguments?.getInt("id") ?: 0)
        }
    }
}