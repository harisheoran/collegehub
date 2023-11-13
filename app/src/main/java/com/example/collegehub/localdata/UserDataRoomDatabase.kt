package com.example.collegehub.localdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class UserDataRoomDatabase : RoomDatabase() {

    abstract fun userDataDao(): UserDataDao

    companion object {
        @Volatile
        private var INSTANCE: UserDataRoomDatabase? = null

        fun database(context: Context): UserDataRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataRoomDatabase::class.java,
                    "user_data_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}