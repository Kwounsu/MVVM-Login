package com.example.login.model

data class UserData (
    var id: String,
    var password: String
)

class User {

    fun loginCheck(user: UserData): Int {
        val userDB = mapOf(
            "user1" to "123456",
            "bob" to "123"
        )
        return when (userDB[user.id]) {
            user.password -> 0
            null -> 1
            else -> 2
        }
    }

}