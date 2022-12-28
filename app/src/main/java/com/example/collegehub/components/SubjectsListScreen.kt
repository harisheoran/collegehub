package com.example.collegehub.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.collegehub.data.DepartmentList
import com.example.collegehub.data.SubjectList
import com.example.collegehub.model.Department
import com.example.collegehub.model.Subject

@Composable
fun SubjectsListScreen(department: Department, deptId: Int){
    val subjectList = department.semestersList[deptId].subjectList


    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(subjectList){ subject ->
            SubjectCard(subject)
        }
    }

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SubjectCard(subject: Subject) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp).size(50.dp),
        ) {
        Row() {
            Image(painterResource(subject.subjectImg), contentDescription = null,
                modifier = Modifier.size(100.dp))

            Text(text = stringResource(subject.subjectName),
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                style = MaterialTheme.typography.body1)

        }
    }
}
