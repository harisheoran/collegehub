package com.example.collegehub.data

import com.example.collegehub.R
import com.example.collegehub.model.Subject

//singleton class
object SubjectList {
    val pkg1stSem = listOf<Subject>(
        Subject("Mathematics", R.drawable.math),
        Subject("English", R.drawable.english),
        Subject("Bee", R.drawable.electrical),
        Subject("Workshop", R.drawable.physics)
    )

    val pkg2ndSem = listOf<Subject>(
        Subject("Mathematics", R.drawable.math),
        Subject("Chemistry", R.drawable.chemistry),
        Subject("English", R.drawable.english),
        Subject("PPS", R.drawable.cse),
        Subject("Environmental Science")
    )

    // Packaging 3rd to 8th semester
    val packaging3rdSem = listOf<Subject>(
        Subject("Applied Science for Packaging"),
        Subject("Engineering Science for Printing"),
        Subject("Elements of packaging"),
        Subject("Package Printing Process"),
        Subject("Graphic Design "),
        Subject("Indian Constitution")
    )

    // Printing 3rd to 8th semester
    val printing3rdSem = listOf<Subject>(
        Subject("Applied Science for Printing"),
        Subject("Engineering Science for Packaging"),
        Subject("Pre Press Technology"),
        Subject("IPP"),
        Subject("Graphic Design"),
        Subject("Content Management"),
        Subject("Indian Constituent ")
    )

    // Civil
    val civil3rdSemester = listOf<Subject>(
        Subject("Introduction to Civil Engineering"),
        Subject("Surveying-1"),
        Subject("Building Construction"),
        Subject("Strength of Material"),
        Subject("Fluid Mechanics"),
        Subject("Sureying -1Lab"),
        Subject("Building Construction Lab"),
        Subject("Strength of Material Lab"),
        Subject("Fluid Mechanics Lab"),
        Subject("Environmental Science"),
    )

    val civil4thSemester = listOf<Subject>(
        Subject("Design of Concrete Structures-1"),
        Subject("Structural Analysis-1"),
        Subject("Advanced Fluid Mechanics"),
        Subject("Concrete Technlogy"),
        Subject("Design of Concrete Structures-1 Lab"),
        Subject("Structural Analysis-1 Lab"),
        Subject("Advanced Fluid Mechanics"),
        Subject("Environmental Engineering Lab"),
        Subject("Concrete Technology Lab"),
        Subject("Environmental Engineering"),
    )

    val civil5thSemester = listOf<Subject>(
        Subject("Economics for Engineers"),
        Subject("Irrigation & Water Resource Engineering"),
        Subject("Structural Analysis -2"),
        Subject("Surveying -2"),
        Subject("Design of Concrete Structure -2"),
        Subject("Structural Analysis -2 Lab"),
        Subject("Suryeying -2 Lab"),
        Subject("Survey Camp"),
        Subject("Software Lab -1"),
        Subject("Essence of Indian Traditional Knowledge"),
        Subject("Open Electice -1")
    )

    val civil6thSemester = listOf<Subject>(
        Subject("Fundamentals of Management for Engineers"),
        Subject("Transportation Engineering -1"),
        Subject("Sewage Treatment"),
        Subject("Soil Mechanics"),
        Subject("Design of Steel Structure -1"),
        Subject("Transportation Engineering -1 Lab"),
        Subject("Sewage & Sewage Treatment Lab"),
        Subject("Soil Mechanics Lab"),
        Subject("Professional Elective Course -1"),
        Subject("Open Elective -2"),
    )

    val civil7thSemester = listOf<Subject>(
        Subject("Green Building & thier Techniques"),
        Subject("Transportation Engineering -2"),
        Subject("Design of Steel Structure -2"),
        Subject("Professional Elective Course -2"),
        Subject("Professional Elective Course -3"),
        Subject("Open Elective -3"),
        Subject("PROJECT -1"),
        Subject("Industrial Training -1"),
        Subject("Project Writing Lab"),
        Subject("Software Lab -2"),
    )

    val civil8thSemester = listOf<Subject>(
        Subject("Construction Costing & Management"),
        Subject("Transportation Engineering -3"),
        Subject("Professional Elective Course -4"),
        Subject("Professional Elective Course -5"),
        Subject("PROJECT -2"),
        Subject("General Fitness for Profession"),
    )

    // Food

    // CSE

    // CSE A.I.

    // IT

    // Mechanical

    // Electrical

    // Electronics
    val electronics1stSem = listOf<Subject>(
        Subject("Physics"),
        Subject("BEE"),
        Subject("Workshop"),
        Subject("Math -1"),
    )
    val electronics2ndSemester = listOf<Subject>(
        Subject("Math -2"),
        Subject("Chemistry"),
        Subject("Engineering Graphic & Design"),
        Subject("Environmental Studies"),
        Subject("English"),
    )
    val electronics3rdSemester = listOf<Subject>(

    )
    val electronics4thSemester = listOf<Subject>(
        Subject("Sensors & Measuring Instruments"),
        Subject("Analog Electronics -2"),
        Subject("Analog & Digital Communication"),
        Subject("Electromagnetic Theory"),
        Subject("Python & its application in electronics"),
        Subject("Essence of Indian Traditional Knowledge"),
        Subject("Human values & Personality Development")
    )

    val electronics5thSemester = listOf<Subject>(
        Subject("Microwave Engineering Instruments"),
        Subject("Embedded System Designs"),
        Subject("Control System Engineering"),
        Subject("Fundamental of Mgt. for Engineering"),
        Subject("DSA"),
        Subject("Optional Subject"),
    )
    val electronics6thSemester = listOf<Subject>(

    )
    val electronics7thSemester = listOf<Subject>(

    )
    val electronics8thSemester = listOf<Subject>(

    )
}