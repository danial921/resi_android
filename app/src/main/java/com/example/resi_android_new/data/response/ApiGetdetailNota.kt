package com.example.resi_android_new.data.response


import com.google.gson.annotations.SerializedName

data class ApiGetdetailNota(
   @field:SerializedName("detai_bill")
    val detaiBill: ApiDetaiBill,
   @field:SerializedName("message")
    val message: String,
   @field:SerializedName("status")
    val status: Boolean
): java.io.Serializable

data class ApiProductdetail(
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("price")
    val price: Int,
    @field:SerializedName("quantity")
    val quantity: Int,
    @field:SerializedName("total")
    val total: Int
): java.io.Serializable

data class ApiDetaiBill(
   @field:SerializedName("created_at")
    val createdAt: String,
   @field:SerializedName("diskon")
    val diskon: Double,
   @field:SerializedName("hargaJual")
    val hargaJual: Double,
   @field:SerializedName("id")
    val id: String,
   @field:SerializedName("kembalian")
    val kembalian: Double,
   @field:SerializedName("shop_adress")
    val shopAdress: String,
   @field:SerializedName("shop_name")
    val ShopName: String,
   @field:SerializedName("shop_phone")
    val PhoneNumber: String,
   @field:SerializedName("shopeId")
    val shopeId: String,
   @field:SerializedName("total")
    val total: Double,
   @field:SerializedName("tunai")
    val tunai: Double,
   @field:SerializedName("updated_at")
    val updatedAt: Any,
   @field:SerializedName("urlPhoto")
    val urlPhoto: String,
   @field:SerializedName("userId")
    val userId: String,
   @field:SerializedName("productdetails")
    val productdetails: List<ApiProductdetail>,
): java.io.Serializable