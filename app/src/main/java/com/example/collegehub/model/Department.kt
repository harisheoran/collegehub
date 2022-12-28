package com.example.collegehub.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.collegehub.data.Semesters

class Department(
    @StringRes val deptName: Int,
    @DrawableRes val deptImg : Int,
    val semestersList: List<Semester>,
    val id: Int,
)