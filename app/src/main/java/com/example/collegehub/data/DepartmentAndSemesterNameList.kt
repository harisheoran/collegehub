package com.example.collegehub.data

import com.example.collegehub.model.Department
import com.example.collegehub.model.Semester

object DepartmentAndSemesterNameList {
    fun departmentList(): List<Department> {
        return listOf(
            Department("Civil Engineering", 0),
            Department("Computer Science", 1),
            Department("Computer Science A.I.", 2),
            Department("Electronics", 3),
            Department("Electrical Engineering", 4),
            Department("Food Technology", 5),
            Department("Mechanical Engineering", 6),
            Department("Inforamtion Technology", 7),
            Department("Packaging Technology", 8),
            Department("Printing Technology", 9),
        )
    }

    fun semesterList(): List<Semester> {
        return listOf(
            Semester("1st", 0),
            Semester("2nd", 1),
            Semester("3rd", 2),
            Semester("4th", 3),
            Semester("5th", 4),
            Semester("6th", 5),
            Semester("7th", 6),
            Semester("8th", 7),
        )
    }
}