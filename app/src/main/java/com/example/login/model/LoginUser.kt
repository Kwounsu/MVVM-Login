package com.example.login.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.login.BR

//class LoginUser (private var userId: String, private var userPassword: String): BaseObservable() {
data class LoginUser (var userId: String, var userPassword: String)//: BaseObservable() {

//    @Bindable
//    fun getUserId(): String{
//        return userId
//    }
//
//    fun setUserId(userId: String) {
//        this.userId = userId
//        notifyPropertyChanged(BR.userId)
//    }
//
//    @Bindable
//    fun getUserPassword(): String{
//        return userPassword
//    }
//
//    fun setUserPassword(userPassword: String) {
//        this.userPassword = userPassword
//        notifyPropertyChanged(BR.userPassword)
//    }
//}