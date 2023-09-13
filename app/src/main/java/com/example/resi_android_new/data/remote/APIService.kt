package com.example.resi_android_new.data.remote

import com.example.resi_android_new.data.response.*
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @POST("login")
    @FormUrlEncoded
    fun loginUser(@Field("email") email : String, @Field("password") password : String) : Call<LoginResponse>

    @POST("register")
    @FormUrlEncoded
    fun registerUser( @Field("name") nama : String, @Field("email") email : String, @Field("phoneNumber") phoneNumber : String, @Field("password") password : String) : Call<RegisterResponse>

    @GET("bill")
    fun getAllBill(@Header("Authorization") token : String, @Query("limit") limit : Int) : Call<GetHistoryPayment>

    @GET("bill/{idBill}")
    fun getDetailBillById(@Path("idBill") idBill : String) : Call<ApiGetdetailNota>
}