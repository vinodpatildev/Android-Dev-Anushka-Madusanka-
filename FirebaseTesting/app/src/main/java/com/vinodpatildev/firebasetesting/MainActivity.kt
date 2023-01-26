package com.vinodpatildev.firebasetesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.vinodpatildev.firebasetesting.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        auth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener{
            registerUser()
        }

        binding.btnLogin.setOnClickListener{
            loginUser()
        }

        binding.btnLogout.setOnClickListener{
            if(auth.currentUser != null){
                auth.signOut()
                checkLoggedInState()
            }
        }

    }

    private fun registerUser(){
        showProgressBar()
        val email = binding.etEmailRegister.text.toString()
        val password = binding.etPasswordRegister.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.createUserWithEmailAndPassword(email,password).await()
                    withContext(Dispatchers.Main){
                        binding.etEmailRegister.text.clear()
                        binding.etPasswordRegister.text.clear()
                        checkLoggedInState()
                        hideProgressBar()
                    }
                }catch (exc : Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@MainActivity,exc.message,Toast.LENGTH_LONG).show()
                    }
                    hideProgressBar()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        checkLoggedInState()
    }

    private fun loginUser(){
        showProgressBar()

        val email = binding.etEmailLogin.text.toString()
        val password = binding.etPasswordLogin.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.signInWithEmailAndPassword(email,password).await()
                    withContext(Dispatchers.Main){
                        binding.etEmailLogin.text.clear()
                        binding.etPasswordLogin.text.clear()
                        checkLoggedInState()
                        hideProgressBar()
                    }
                }catch (exc : Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@MainActivity,exc.message,Toast.LENGTH_LONG).show()
                    }
                    hideProgressBar()
                }
            }

        }
    }

    private fun checkLoggedInState() {
        if (auth.currentUser == null) { // not logged in
            binding.tvLoggedIn.text = "You are not logged in"
        } else {
            binding.tvLoggedIn.text = "You are logged in!"
        }
    }

    private fun showProgressBar(){
        binding.progressBar.visibility = View.VISIBLE
    }
    private fun hideProgressBar(){
        binding.progressBar.visibility = View.INVISIBLE
    }

}