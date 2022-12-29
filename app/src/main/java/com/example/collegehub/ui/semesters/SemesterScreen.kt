package com.example.collegehub.ui.semesters

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.collegehub.R
import com.example.collegehub.components.CardDivider
import com.example.collegehub.components.SubjectCard
import com.example.collegehub.data.SemestersList
import com.example.collegehub.model.Department
import com.example.collegehub.model.Semester
import com.example.collegehub.model.Subject
import com.example.collegehub.ui.AppTopBar

@Composable
fun SemesterListScreen(semesterList: List<Semester>, navController: NavHostController) {
    Scaffold(topBar = {
        AppTopBar(modifier = Modifier.padding(bottom = 4.dp), R.string.chooseSem, )
    }) {
        LazyColumn(modifier = Modifier.padding(it).fillMaxSize()) {
            items(semesterList) { semester ->
                SemesterCard(semester, navController)
                CardDivider()
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SemesterCard(semester: Semester, navController: NavHostController) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp)
        .size(75.dp)
        .clickable {
            navController.navigate("${SemesterRoute.semesterDetails.name}/${semester.semesterNum}")
        }) {
        Text(
            text = stringResource(semester.semesterName),
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            style = MaterialTheme.typography.h2
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SemScreenPreview() {
    SemesterListScreen(SemestersList.pkgSemestersList, navController = rememberNavController())
}
