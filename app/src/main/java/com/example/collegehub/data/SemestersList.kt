package com.example.collegehub.data

import com.example.collegehub.R
import com.example.collegehub.model.Semester

object SemestersList {
    val pkgSemestersList = listOf<Semester>(
        Semester(0, R.string.firstsem, SubjectList.pkg1stSem),
        Semester(1,R.string.secondsem, SubjectList.pkg1stSem),
        Semester(2,R.string.thirdsem, SubjectList.pkg1stSem),
        Semester(3,R.string.fourthsem, SubjectList.pkg1stSem),
        Semester(4,R.string.fifthsem, SubjectList.pkg1stSem),
        Semester(5,R.string.sixthsem, SubjectList.pkg1stSem),
        Semester(6,R.string.seventhsem, SubjectList.pkg1stSem),
        Semester(7,R.string.eigthsem, SubjectList.pkg1stSem)
    )
}