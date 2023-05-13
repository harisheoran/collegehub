package com.example.collegehub

import android.app.Application
import com.example.collegehub.localdata.UserDataRoomDatabase

class CollegeHubApplication : Application() {
    val database: UserDataRoomDatabase by lazy { UserDataRoomDatabase.database(this)}
}