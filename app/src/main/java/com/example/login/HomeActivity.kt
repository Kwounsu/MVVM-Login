package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.login.databinding.ActivityHomeBinding
import com.example.login.model.UserData

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val bundle = intent.extras
        val id = bundle?.get("id")

        binding.userData = UserData(id.toString(), "password")

        // Invalidates all binding expressions and requests a new rebind to refresh UI.
//        binding.invalidateAll()
    }
}