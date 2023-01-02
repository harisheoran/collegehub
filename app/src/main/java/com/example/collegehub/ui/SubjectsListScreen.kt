package com.example.collegehub.ui

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.collegehub.components.CardDivider
import com.example.collegehub.data.SubjectList
import com.example.collegehub.model.Subject

// scrollable list of Department > semester > Subject list
@Composable
fun SubjectsListScreen(subjectList: List<Subject>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(subjectList) { subject ->
            SubjectCard(subject)
            CardDivider()
        }
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SubjectCard(subject: Subject) {

    Row(modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp).size(80.dp)) {
        Image(
            painterResource(subject.subjectImg), contentDescription = null,
            modifier = Modifier.size(50.dp, 50.dp).padding(top = 8.dp).clip(RoundedCornerShape(4.dp))
        )

        Text(
            text = subject.subjectName,
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Subjectlistpreview(){
    SubjectsListScreen(SubjectList.civil4thSemester)
}