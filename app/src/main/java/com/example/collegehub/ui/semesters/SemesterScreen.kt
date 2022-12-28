package com.example.collegehub.ui.semesters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.collegehub.components.SubjectCard
import com.example.collegehub.model.Department
import com.example.collegehub.model.Semester
import com.example.collegehub.model.Subject
@Composable
fun SemesterListScreen(semesterList:List<Semester> ,navController: NavHostController){
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(semesterList){ semester ->
            SemesterCard(semester, navController)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SemesterCard(semester: Semester, navController: NavHostController) {
    val number = semester.semesterNum + 1
    val semName = number.toString()

    Card(
        modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp).size(50.dp),
        onClick = {
            navController.navigate("${SemesterRoute.semesterDetails.name}/${semester.semesterNum}")
        }
    ) {
        Row() {
            Text(text = semName,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                style = MaterialTheme.typography.body1)
        }
    }
}
