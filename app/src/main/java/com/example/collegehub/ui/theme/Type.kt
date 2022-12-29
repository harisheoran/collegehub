package com.example.collegehub.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.collegehub.R

val robotoregular = FontFamily(
    Font(R.font.robotomonoregular)
)
val robotolight = FontFamily(
    Font(R.font.robotomonolight)
)
val robotobold = FontFamily(
    Font(R.font.robotmonobold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = robotolight,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = robotobold,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    h2 = TextStyle(
        fontFamily = robotoregular,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = robotoregular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
)