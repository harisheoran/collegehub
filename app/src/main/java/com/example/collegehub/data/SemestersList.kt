package com.example.collegehub.data

import com.example.collegehub.R
import com.example.collegehub.model.Semester

object SemestersList {
    val pkgSemestersList = listOf<Semester>(
        Semester(0, R.string.firstsem, SubjectList.pkg1stSem),
        Semester(1, R.string.secondsem, SubjectList.pkg1stSem),
        Semester(2, R.string.thirdsem, SubjectList.pkg1stSem),
        Semester(3, R.string.fourthsem, SubjectList.pkg1stSem),
        Semester(4, R.string.fifthsem, SubjectList.pkg1stSem),
        Semester(5, R.string.sixthsem, SubjectList.pkg1stSem),
        Semester(6, R.string.seventhsem, SubjectList.pkg1stSem),
        Semester(7, R.string.eigthsem, SubjectList.pkg1stSem)
    )

    val civilSemesterList = listOf<Semester>(
        Semester(0, R.string.firstsem, SubjectList.pkg1stSem),
        Semester(1, R.string.secondsem, SubjectList.pkg2ndSem),
        Semester(2, R.string.thirdsem, SubjectList.civil3rdSemester),
        Semester(3, R.string.fourthsem, SubjectList.civil4thSemester),
        Semester(4, R.string.fifthsem, SubjectList.civil5thSemester),
        Semester(5, R.string.sixthsem, SubjectList.civil6thSemester),
        Semester(6, R.string.seventhsem, SubjectList.civil7thSemester),
        Semester(7, R.string.eigthsem, SubjectList.civil8thSemester)
    )

    val electronicsSemesterList = listOf<Semester>(
        Semester(0, R.string.firstsem, SubjectList.electronics1stSem),
        Semester(1, R.string.secondsem, SubjectList.electronics2ndSemester),
        Semester(2, R.string.thirdsem, SubjectList.electronics3rdSemester),
        Semester(3, R.string.fourthsem, SubjectList.electronics4thSemester),
        Semester(4, R.string.fifthsem, SubjectList.electronics5thSemester),
        Semester(5, R.string.sixthsem, SubjectList.electronics6thSemester),
        Semester(6, R.string.seventhsem, SubjectList.electronics7thSemester),
        Semester(7, R.string.eigthsem, SubjectList.electronics8thSemester)
    )

}