package com.example.roomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.roomdb.databinding.ActivityLoggedInBinding
import com.example.roomdb.model.User
import com.example.roomdb.ui.main.MainActivity
import com.example.roomdb.viewmodel.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoggedInActivity : AppCompatActivity() {
    private var binding: ActivityLoggedInBinding? = null
    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoggedInBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        getUserData()
        setUpListeners()

    }

    private fun getUserData() {
      userViewModel.userData.observe(this){ users ->
          val userName = intent.getStringExtra("NAME")
          Log.d("listName", "listName: $userName")
          val user : User? = users.find { it.name == userName }
//          var user : User? = null
//          users.forEach {
//              if (it.name == userName) {
//                  user = it
//                  return@forEach
//              }
//          }

          
//          val names = arrayListOf<String>()
//          users.forEach {
//              it.name?.let { it1 -> names.add(it1) }
//          }
//          return names
//          val userNames = users.map {
//              it.name ?: ""
//          }

          binding?.uiTvDisplayName?.text = userName
          if (user != null) {
              binding?.uiTvDisplayAge?.text = user.age
              binding?.uiTvDisplayGender?.text = user.gender
              binding?.uiTvDisplayEmail?.text = user.email
          }
          //val currentItem= it.last()
          //binding?.uiTvDisplayName?.text = currentItem.name
//          binding?.uiTvDisplayAge?.text = currentItem.age
//          binding?.uiTvDisplayGender?.text = currentItem.gender
//          binding?.uiTvDisplayEmail?.text = currentItem.email
      }
    }

    private fun deleteUser() {
        CoroutineScope(Dispatchers.IO).launch {
            userViewModel.deleteUserData()
        }

    }

    private fun setUpListeners() {
        binding?.uiBtnLogout?.setOnClickListener {
            deleteUser()
            Log.d("userData", "getUserData: " + it.toString())
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}