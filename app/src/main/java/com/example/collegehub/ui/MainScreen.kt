package com.example.collegehub.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.collegehub.R
import com.example.collegehub.components.CollegeHubBar
import com.example.collegehub.data.DepartmentList
import com.example.collegehub.model.CollegeHubViewModel

// all Routes
enum class MainRoutes(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Semesters(R.string.chooseSem),
    NewInfo(R.string.whatsNew),
    Subjects(R.string.subjects)
}

// Main Entry of app + Navigation setup
@Composable
fun MainScreen() {
    val navController: NavHostController = rememberNavController()
    var departmentList = DepartmentList.deptsList
    //create viewmodel
    val viewModel: CollegeHubViewModel = viewModel()
    val uiState by viewModel.uistate.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MainRoutes.valueOf(
        backStackEntry?.destination?.route ?: MainRoutes.Home.name
    )

    Scaffold(topBar = {
        CollegeHubBar(modifier = Modifier,
            barText = currentScreen.title,
            canGoBack = navController.previousBackStackEntry != null,
            currentScreen = currentScreen,
            navigateUp = { navController.navigateUp() })
    }) {
        NavHost(
            navController = navController,
            startDestination = MainRoutes.Home.name,
            modifier = Modifier.padding(it)
        ) {
            // Home Screen
            composable(route = MainRoutes.Home.name) {
                Home(list = departmentList, navController, viewModel)
            }
            // New Info section
            composable(route = MainRoutes.NewInfo.name) {
                NewInfo()
            }

            // Semester List screen
            composable(route = MainRoutes.Semesters.name) {
                var semesterListOfDepartment = departmentList[uiState.departmentId].semestersList
                SemesterListScreen(semesterListOfDepartment, navController, viewModel)
            }

            // subject list screen of a particular semester
            composable(route = MainRoutes.Subjects.name) {
                var subjectListOfDepartment =
                    departmentList[uiState.departmentId].semestersList[uiState.semesterNum].subjectList
                SubjectsListScreen(subjectListOfDepartment)
            }
        }
    }
}