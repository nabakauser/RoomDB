package com.example.roomdb.viewmodel

import androidx.lifecycle.*
import com.example.roomdb.model.User
import com.example.roomdb.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository): ViewModel() {

    val userData: LiveData<List<User>> = userRepository.allUserData

    fun saveUserName(user: User) {
            userRepository.addUser(user)
    }

    fun deleteUserData() {
        userRepository.deleteUser()
    }
}