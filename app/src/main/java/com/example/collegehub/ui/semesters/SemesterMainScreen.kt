package com.example.collegehub.ui.semesters

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import com.example.collegehub.R
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.collegehub.components.SubjectsListScreen
import com.example.collegehub.data.DepartmentList
import com.example.collegehub.model.Department


enum class SemesterRoute(@StringRes val title: Int){
    semester(title = R.string.semester),
    semesterDetails(title = R.string.semesterDetails),
    first(title = R.string.firstsem),
    second(title = R.string.secondsem),
    third( title = R.string.thirdsem),
    fourth(title = R.string.fourthsem),
    fifth(title = R.string.fifthsem),
    sixth(title = R.string.sixthsem),
    seventh(title = R.string.seventhsem),
    eigth(title = R.string.eigthsem)
}

@Composable
fun SemesterMainScreen(departmentList: List<Department>, deptId: Int){
    val navController: NavHostController = rememberNavController()
    val department = departmentList[deptId]


    NavHost(
        startDestination = SemesterRoute.semester.name,
        navController = navController,
        modifier = Modifier
    ){
        composable(route = SemesterRoute.semester.name){
            SemesterListScreen(department.semestersList, navController)
        }

        composable(route = "${SemesterRoute.semesterDetails.name}/{semesterNum}",
            arguments = listOf(navArgument("semesterNum") {type = NavType.IntType}),
        ){
            SubjectsListScreen(department,it.arguments?.getInt("semesterNum") ?: 0)
        }

    }
}