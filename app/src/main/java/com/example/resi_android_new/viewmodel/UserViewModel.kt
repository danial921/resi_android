package com.example.resi_android_new.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.resi_android_new.data.response.LoginResponse
import com.example.resi_android_new.data.response.RegisterResponse
import com.example.resi_android_new.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private var userRepo : UserRepository) : ViewModel(){

    fun loginUser(email : String, password : String) : LiveData<LoginResponse?> = userRepo.loginUser(email, password)
    fun registerUser(name : String, email : String, phoneNumber : String, password : String) : LiveData<RegisterResponse?> = userRepo.registerUser(name, email,phoneNumber, password)

    fun getRegisterErrorMessage() : LiveData<String> = userRepo.registerErrorMessage
    fun getLoginErrorMessage() : LiveData<String> = userRepo.loginErrorMessage
}