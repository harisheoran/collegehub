package com.example.collegehub.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.collegehub.R
import com.example.collegehub.data.DepartmentList
import com.example.collegehub.data.SemestersList
import com.example.collegehub.data.SubjectList
import com.example.collegehub.model.Department
import com.example.collegehub.model.Subject
import com.example.collegehub.ui.AppTopBar

@Composable
fun SubjectsListScreen(department: Department, semesterNum: Int) {
    val subjectList = department.semestersList[semesterNum].subjectList
    val semesterName = department.semestersList[semesterNum].semesterName
    Scaffold(
        topBar = {
            AppTopBar(modifier = Modifier.padding(bottom = 4.dp), semesterName)
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it).fillMaxSize()) {
            items(subjectList) { subject ->
                SubjectCard(subject)
                CardDivider()
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SubjectCard(subject: Subject) {

    Row(modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp).size(80.dp)) {
        Image(
            painterResource(subject.subjectImg), contentDescription = null,
            modifier = Modifier.size(50.dp, 50.dp).clip(RoundedCornerShape(4.dp))
        )

        Text(
            text = stringResource(subject.subjectName),
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            style = MaterialTheme.typography.body1
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SubjectListPreview() {
    SubjectsListScreen(
        Department(
            R.string.pkg,
            R.drawable.pkg,
            SemestersList.pkgSemestersList,
            0,
        ), 0
    )
}