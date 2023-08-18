package com.example.resi_android_new.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.resi_android_new.data.response.LoginResponse
import com.example.resi_android_new.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private var userRepo : UserRepository) : ViewModel(){

    fun loginUser(email : String, password : String) : LiveData<LoginResponse?> = userRepo.loginUser(email, password)

    fun getLoginErrorMessage() : LiveData<String> = userRepo.loginErrorMessage
}