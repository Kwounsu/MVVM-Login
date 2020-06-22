package com.example.login.model

class User {
    fun loginCheck(id: String, password: String): Int {
        val userDB = mapOf(
            "user1" to "123456",
            "bob" to "123"
        )
        return when (userDB[id]) {
            password -> 0
            null -> 1
            else -> 2
        }
    }
}