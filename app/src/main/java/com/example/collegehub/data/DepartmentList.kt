package com.example.collegehub.data

import com.example.collegehub.R
import com.example.collegehub.model.Department
import com.example.collegehub.model.Semester
import com.example.collegehub.model.Subject

object DepartmentList {
    val deptsList = listOf<Department>(
        Department(
            R.string.pkg,
            R.drawable.pkg,
            SemestersList.pkgSemestersList,
            0,
        ),
        Department(
            R.string.cse, R.drawable.cse,
            SemestersList.pkgSemestersList,
            1
        ),
        Department(
            R.string.food, R.drawable.food,
            SemestersList.pkgSemestersList,
            2
        ),
        Department(
            R.string.it, R.drawable.it,
            SemestersList.pkgSemestersList,
            3
        ),
        Department(
            R.string.mech, R.drawable.mech,
            SemestersList.pkgSemestersList, 4
        ),
        Department(
            R.string.cse_ai, R.drawable.ai,
            SemestersList.pkgSemestersList, 5
        ),
        Department(
            R.string.civil,
            R.drawable.civil,
            SemestersList.pkgSemestersList,
            6
        ),
        Department(
            R.string.ece,
            R.drawable.eceandcomm,
            SemestersList.pkgSemestersList,
            7
        ),
        Department(
            R.string.ec,
            R.drawable.electrical,
            SemestersList.pkgSemestersList,
            8
        ),
        Department(
            R.string.ptg,
            R.drawable.ptg,
            SemestersList.pkgSemestersList,
            9
        )
    )
}