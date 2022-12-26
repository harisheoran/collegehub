package com.example.collegehub.data

import com.example.collegehub.R
import com.example.collegehub.model.Department

object DepartmentList {
    val deptsList = listOf<Department>(
        Department(R.string.pkg, R.drawable.pkg),
        Department(R.string.cse, R.drawable.cse),
        Department(R.string.food, R.drawable.food),
        Department(R.string.it, R.drawable.it),
        Department(R.string.mech, R.drawable.mech),
        Department(R.string.cse_ai, R.drawable.ai),
        Department(R.string.civil, R.drawable.civil),
        Department(R.string.ece, R.drawable.eceandcomm),
        Department(R.string.ec, R.drawable.electrical),
        Department(R.string.ptg, R.drawable.ptg)
    )
}