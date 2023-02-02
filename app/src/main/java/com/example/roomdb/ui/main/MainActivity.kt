package com.example.roomdb.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.roomdb.LoggedInActivity
import com.example.roomdb.databinding.ActivityMainBinding
import com.example.roomdb.model.User
import com.example.roomdb.viewmodel.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setUpListeners()
    }

    private fun setUpListeners() {
        binding?.uiBtnSubmit?.setOnClickListener {
            saveUserData()
            navigateToLoggedInActivity()
        }
    }

    private fun saveUserData() {
        CoroutineScope(Dispatchers.IO).launch {
            val user = User(
                name = binding?.uiEtName?.text.toString() ,
                age = binding?.uiEtAge?.text.toString(),
                gender = binding?.uiEtGender?.text.toString(),
                email = binding?.uiEtEmail?.text.toString()
            )
            userViewModel.saveUserName(user)
        }

    }


    private fun navigateToLoggedInActivity() {
        val name = binding?.uiEtName?.text.toString()
        val intent = Intent(this,LoggedInActivity::class.java)
        intent.putExtra("NAME", name)
        startActivity(intent)

    }
}