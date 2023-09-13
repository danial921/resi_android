package com.example.resi_android_new.data.response


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("userData")
    val userData: UserData
)

data class UserData(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("profile_picture")
    val profilePicture: Any,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("uuid")
    val uuid: String
)

data class RegisterErrorResponse(
    @SerializedName("status")
    val error: String,
    @SerializedName("message")
    val message: String,
)