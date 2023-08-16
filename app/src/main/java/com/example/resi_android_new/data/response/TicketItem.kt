package com.example.resi_android_new.data.response

import com.google.gson.annotations.SerializedName

data class GetPreviewHistoryPayment(
    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("date_time")
    val date_time: String,

    @field:SerializedName("total")
    val total: String,
): java.io.Serializable