package com.example.resi_android_new.data.response


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("expires_in")
    val expiresIn: Int,

    @SerializedName("uuid")
    val uuid: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("phoneNumber")
    val phoneNumber: String,

    @SerializedName("message")
    val message: String,

    @SerializedName("status")
    val status: Boolean,

    @SerializedName("token_type")
    val tokenType: String
)

data class LoginErrorResponse(
    @SerializedName("error")
    val error: String,
)