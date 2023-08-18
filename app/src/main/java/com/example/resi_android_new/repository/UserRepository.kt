package com.example.resi_android_new.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.resi_android_new.data.remote.APIService
import com.example.resi_android_new.data.response.*
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(var apiService: APIService) {
    private val _loginUser = MutableLiveData<LoginResponse?>()
    val loginUser: LiveData<LoginResponse?> = _loginUser
    val loginErrorMessage = MutableLiveData<String>()


    fun loginUser(email: String, password: String): LiveData<LoginResponse?> {
        apiService.loginUser(email, password).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                val dataResponse = response.body()
                if (response.isSuccessful && dataResponse != null) {
                    _loginUser.postValue(dataResponse)
                    dataResponse.message.let { Log.e("Response message : ", it) }
                } else if(response.code() == 400 || response.code() == 401) {
                    _loginUser.postValue(null)
                    val gson = GsonBuilder().create()
                    val errorResponse = gson.fromJson(response.errorBody()?.string(), LoginErrorResponse::class.java)
                    loginErrorMessage.postValue(errorResponse.error)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("Error onFailure : ", t.message!!)
            }
        })
        return loginUser
    }


}