package com.example.collegehub.components

import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambdaN
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.collegehub.ui.MainRoutes

// Top app bar
@Composable
fun CollegeHubBar(
    modifier: Modifier,
    @StringRes barText: Int,
    canGoBack: Boolean,
    currentScreen: MainRoutes,
    navigateUp: () -> Unit
) {
    TopAppBar(
        title = {
            Text(stringResource(barText), style = MaterialTheme.typography.h1)
        },
        navigationIcon = {
            if (canGoBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        },
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary
    )
}