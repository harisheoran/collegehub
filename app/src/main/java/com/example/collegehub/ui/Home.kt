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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.collegehub.R
import com.example.collegehub.data.DepartmentList
import com.example.collegehub.model.Department
import com.example.collegehub.ui.theme.CollegeHubTheme

// Main UI, Scrollable list
@Composable
fun Home(list: List<Department>, navController: NavHostController) {
    Scaffold(topBar = {
        AppTopBar(modifier = Modifier.padding(bottom = 4.dp))
    }) { innerpadding ->
        LazyColumn(modifier = Modifier.padding(innerpadding).fillMaxSize()) {
            items(list) { depts ->
                MainUiCard(depts, navController)
            }
        }
    }
}

// cards used in Main UI in Scrollable list
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainUiCard(dept: Department, navController: NavHostController) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
        onClick = {
            navController.navigate("${MainRoutes.Details.name}/${dept.id}/${dept.deptName}")
        }
    ) {
        Row() {
            Image(
                painterResource(dept.deptImg), contentDescription = null,
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(dept.deptName),
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

// Main UI Top App Bar
@Composable
fun AppTopBar(modifier: Modifier) {
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
        Home(DepartmentList.deptsList, navController = rememberNavController())
    }
}
