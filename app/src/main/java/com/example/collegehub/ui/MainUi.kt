package com.example.collegehub.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.collegehub.CollegeHub
import com.example.collegehub.R
import com.example.collegehub.data.DepartmentList
import com.example.collegehub.model.Department
import com.example.collegehub.ui.theme.CollegeHubTheme


@Composable
fun MainUIList(list: List<Department>) {
    Scaffold(topBar = {
        CollegeHubBar(modifier = Modifier.padding(bottom = 4.dp))
    }) { innerpadding ->
        LazyColumn(modifier = Modifier.padding(innerpadding).fillMaxSize()) {
            items(list) { depts ->
                MainUiCard(depts)
            }
        }

    }
}

@Composable
fun MainUiCard(dept: Department) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row() {
            Image(
                painterResource(dept.deptImg), contentDescription = null,
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(dept.deptname),
                modifier = Modifier.padding(start = 16.dp)
            )

        }
    }
}

@Composable
fun CollegeHubBar(modifier: Modifier) {
    TopAppBar(
        title = {
            Text(stringResource(R.string.app_name))
        },
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary
    )
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AppMainUIPreview() {
    CollegeHubTheme(darkTheme = false) {
        MainUIList(DepartmentList.deptsList)
    }
}