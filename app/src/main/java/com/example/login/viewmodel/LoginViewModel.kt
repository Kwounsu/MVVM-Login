package com.example.login.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.login.model.User
import com.example.login.model.UserData

//class LoginViewModel(): ViewModel() {
class LoginViewModel(application: Application): AndroidViewModel(application) {

    var _loginResultLiveData: MutableLiveData<Int> = MutableLiveData()
    val loginResultLiveData: LiveData<Int> = _loginResultLiveData

    /* loginViewModel.login(user: User)
        return 0: login success
        return 1: id does not exist
        return 2: password not match */
    fun login(userData: UserData) {
        val user = User()
        when (user.loginCheck(userData)) {
            0 -> _loginResultLiveData.postValue(0)
            1 -> _loginResultLiveData.postValue(1)
            else -> _loginResultLiveData.postValue(2)
        }
    }

}