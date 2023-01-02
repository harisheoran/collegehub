package com.example.collegehub.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.collegehub.R

class Subject(
    val subjectName: String,
    @DrawableRes val subjectImg: Int = R.drawable.comingsoon,
)