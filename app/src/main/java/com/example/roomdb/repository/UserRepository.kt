package com.example.roomdb.repository

import androidx.lifecycle.LiveData
import com.example.roomdb.UserDao
import com.example.roomdb.model.User
import kotlinx.coroutines.flow.Flow

class UserRepository (private val userDao: UserDao){

    fun addUser(user: User) {
        userDao.addUsers(user)
    }
    val allUserData: LiveData<List<User>> = userDao.getUserData()

    fun deleteUser() {
        userDao.deleteUser()
    }
//
//    fun getUserData(): LiveData<List<User>> {
//        return userDao.getUserData()
//    }


}