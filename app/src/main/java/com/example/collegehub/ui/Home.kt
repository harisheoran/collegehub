package com.example.collegehub.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.collegehub.R
import com.example.collegehub.components.CardDivider
import com.example.collegehub.data.DepartmentList
import com.example.collegehub.model.CollegeHubViewModel
import com.example.collegehub.model.Department
import com.example.collegehub.ui.theme.CollegeHubTheme

// Main UI, Scrollable list of Departments
@Composable
fun Home(list: List<Department>, navController: NavHostController, viewModel: CollegeHubViewModel) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item { InfoUpdateCard(navController) }
        item {
            DepartmentCard(list, navController, viewModel)
        }
    }
}

// cards used in Main UI in Scrollable list
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DepartmentCard(list: List<Department>, navController: NavHostController, viewModel: CollegeHubViewModel) {
    Column {
        list.forEach {
            SimpleCards(it, navController, viewModel)
        }
    }
}

@Composable
fun SimpleCards(dept: Department, navController: NavHostController, viewModel: CollegeHubViewModel) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp)
        .clickable {
            navController.navigate(MainRoutes.Semesters.name)
            viewModel.updateDepartmentId(dept.id)
        }) {
        Image(
            painterResource(dept.deptImg), contentDescription = null,
            modifier = Modifier.size(80.dp, 80.dp).padding(top = 8.dp, bottom = 8.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(dept.deptName),
            modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
fun InfoUpdateCard(navController: NavHostController) {
    Column(modifier = Modifier.padding(8.dp)
        .clickable {
            navController.navigate(MainRoutes.NewInfo.name)
        }) {
        Text(
            text = stringResource(R.string.whatsNew),
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.h2
        )
        Image(
            painterResource(id = R.drawable.newforyou), contentDescription = null,
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Sample Papers are available now.",
            modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 16.dp),
            style = MaterialTheme.typography.h3
        )
        CardDivider()
    }
}