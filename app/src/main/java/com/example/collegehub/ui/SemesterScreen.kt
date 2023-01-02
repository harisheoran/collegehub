package com.example.collegehub.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.collegehub.components.CardDivider
import com.example.collegehub.model.CollegeHubViewModel
import com.example.collegehub.model.Semester

@Composable
fun SemesterListScreen(semesterList: List<Semester>, navController: NavHostController, viewModel: CollegeHubViewModel) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(semesterList) { semester ->
            SemesterCard(semester, navController, viewModel)
            CardDivider()
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SemesterCard(semester: Semester, navController: NavHostController, viewModel: CollegeHubViewModel) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp)
        .size(75.dp)
        .clickable {
            navController.navigate(MainRoutes.Subjects.name)
            viewModel.updateSemesterNum(semester.semesterNum)
        }) {
        Text(
            text = stringResource(semester.semesterName),
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            style = MaterialTheme.typography.h2
        )
    }
}