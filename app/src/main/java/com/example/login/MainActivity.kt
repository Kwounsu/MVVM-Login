package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.login.databinding.ActivityMainBinding
import com.example.login.model.LoginUser
import com.example.login.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val loginUser = LoginUser("","")
        binding.loginUser = loginUser

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.loginVM = loginViewModel

        loginViewModel.loginResultLiveData.observe(this, Observer {loginResult ->
            if (loginResult == 0) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else if (loginResult == 1){
                Toast.makeText(this,"Login Failed: Invalid ID",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Login Failed: Wrong password.",Toast.LENGTH_SHORT).show()
            }
        })

//        binding.buttonLogin.setOnClickListener {
//            loginViewModel.login(binding.editTextId.text.toString(), binding.editTextPassword.text.toString())
//        }
    }
}