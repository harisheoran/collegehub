package com.example.collegehub.localdata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userData")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val userName: String,
    @ColumnInfo(name = "department")
    val department: String?,
    @ColumnInfo(name = "semester")
    val semester: String?,
    @ColumnInfo(name = "departmentId")
    val departmentId: Int?,
    @ColumnInfo(name = "semesterId")
    val semesterId: Int?
)