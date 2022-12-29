package com.example.collegehub.model

import androidx.annotation.StringRes

class Semester(
    val semesterNum: Int,
    @StringRes val semesterName: Int,
    val subjectList: List<Subject>
)