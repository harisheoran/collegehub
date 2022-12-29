package com.example.collegehub.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.collegehub.R
import com.example.collegehub.data.DepartmentList

import com.example.collegehub.ui.semesters.SemesterMainScreen

enum class MainRoutes {
    Home,
    Details,
    NewInfo
}

@Composable
fun MainScreen() {
    val navController: NavHostController = rememberNavController()
    var departmentList = DepartmentList.deptsList

    NavHost(
        navController = navController,
        startDestination = MainRoutes.Home.name,
        modifier = Modifier
    ) {
        // Home Screen
        composable(route = MainRoutes.Home.name) {
            Home(list = departmentList, navController)
        }

        composable(route = MainRoutes.NewInfo.name) {
            NewInfo()
        }

        // Semester List screen
        composable(
            route = "${MainRoutes.Details.name}/{id}/{name}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            SemesterMainScreen(departmentList, it.arguments?.getInt("id") ?: 0)
        }
    }
}
