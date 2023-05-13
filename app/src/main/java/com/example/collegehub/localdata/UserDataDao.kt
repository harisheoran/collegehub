package com.example.collegehub.localdata

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveUserData(userData: UserData)

    @Update
    suspend fun updateUserData(userData: UserData)

    @Query("SELECT * from userData ORDER BY id DESC")
    fun readUserData(): Flow<UserData>

    @Query("SELECT * from userData WHERE id =:id")
    fun readLoggedInUserData(id: Int): Flow<UserData>

}