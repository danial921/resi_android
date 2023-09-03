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

data class GetHistoryPayment(
    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("bill")
    val bill: List<DetailHistoryPayment>
): java.io.Serializable
data class DetailHistoryPayment(
    @field:SerializedName("bill_id")
    val id: String,

    @field:SerializedName("logo")
    val logo: String,

    @field:SerializedName("store")
    val title: String,

    @field:SerializedName("date")
    val date_time: String,

    @field:SerializedName("total")
    val total: String,
): java.io.Serializable

data class GetDetailPayment(
    @field:SerializedName("shopname")
    val shop_name: String,

    @field:SerializedName("shopadress")
    val shop_adress: String,

    @field:SerializedName("no_telf")
    val no_telf: String,

    @field:SerializedName("logo")
    val logo: String,

    @field:SerializedName("payment_number")
    val payment_number: String,

    @field:SerializedName("payment_date")
    val payment_date: String,

    @field:SerializedName("product")
    val product: List<DetailProduct>,

    @field:SerializedName("discount")
    val discount: String,

    @field:SerializedName("seller_price")
    val seller_price: String,

    @field:SerializedName("total")
    val total: String,

    @field:SerializedName("cash")
    val cash: String,

    @field:SerializedName("return")
    val kembalian: String,
)

data class DetailProduct(
    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("quantity")
    val quantity: String,

    @field:SerializedName("price")
    val price: String,

    @field:SerializedName("total")
    val total: String,
): java.io.Serializable