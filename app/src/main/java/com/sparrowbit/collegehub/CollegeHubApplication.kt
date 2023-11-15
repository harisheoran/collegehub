package com.sparrowbit.collegehub

import android.app.Application
import com.sparrowbit.collegehub.localdata.UserDataRoomDatabase

class CollegeHubApplication : Application() {
    val database: UserDataRoomDatabase by lazy { UserDataRoomDatabase.database(this)}
}