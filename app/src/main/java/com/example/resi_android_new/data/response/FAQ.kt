package com.example.resi_android_new.data.response

import com.google.gson.annotations.SerializedName

data class GetFAQInformation(
    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("content")
    val content: String,
): java.io.Serializable