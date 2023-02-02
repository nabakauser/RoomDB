package com.example.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdb.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // .IGNORE -> ignores the user if already present -> .REPLACE -> replaces old data
    fun addUsers(user: User)

    @Query("SELECT * FROM userTable")
    fun getUserData(): LiveData<List<User>>

    @Query("DELETE FROM userTable")
    fun deleteUser()
}