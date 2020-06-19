package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.login.databinding.ActivityMainBinding
import com.example.login.model.UserData
import com.example.login.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        loginViewModel.loginResultLiveData.observe(this, Observer {
            if (it == 0) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id",binding.editTextId.text.toString())
                startActivity(intent)
                binding.progressBarLogin.visibility = View.INVISIBLE
            } else if (it == 1){
                Toast.makeText(this,"Login Failed: Invalid ID",Toast.LENGTH_SHORT).show()
                binding.progressBarLogin.visibility = View.INVISIBLE
            } else {
                Toast.makeText(this,"Login Failed: Wrong password.",Toast.LENGTH_SHORT).show()
                binding.progressBarLogin.visibility = View.INVISIBLE
            }
        })

        binding.buttonLogin.setOnClickListener {
            binding.progressBarLogin.visibility = View.VISIBLE
            val user = UserData(binding.editTextId.text.toString(), binding.editTextPassword.text.toString())
            loginViewModel.login(user)
        }
    }
}