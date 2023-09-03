package com.example.resi_android_new.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.resi_android_new.data.remote.APIService
import com.example.resi_android_new.data.response.*
import com.google.gson.GsonBuilder
import kotlinx.coroutines.DelicateCoroutinesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.math.log

@Suppress("DeferredResultUnused")
@OptIn(DelicateCoroutinesApi::class)
class PaymentRepository @Inject constructor(var apiService: APIService) {
    private val _paymentHistory = MutableLiveData<GetHistoryPayment?>()
    val getPaymentHistory: LiveData<GetHistoryPayment?> = _paymentHistory
    private val _chosenPaymentHistory = MutableLiveData<DetailHistoryPayment?>()
    val chosenPaymentHistory: MutableLiveData<DetailHistoryPayment?> = _chosenPaymentHistory


    fun setChosenPayment(chosenTicket: DetailHistoryPayment) = _chosenPaymentHistory.postValue(chosenTicket)

    fun clearChosenPayment() = _chosenPaymentHistory.postValue(null)

    fun getPaymentHistory (
        token: String,
        limit: Int
    ):LiveData<GetHistoryPayment?>{
        Log.d("Debug", "Error Check")
        apiService.getAllBill(token, limit)
            .enqueue(object : Callback<GetHistoryPayment> {
                override fun onResponse(
                    call: Call<GetHistoryPayment>,
                    response: Response<GetHistoryPayment>
                ) {
                    Log.d("Debug", response.body().toString())
                    if (response.isSuccessful) {
                        val dataResponse = response.body()
                        _paymentHistory.postValue(dataResponse)
                        dataResponse?.message.let { Log.e("Response message : ", it.toString()) }
                    } else {
                        _paymentHistory.postValue(null)
                    }
                }

                override fun onFailure(call: Call<GetHistoryPayment>, t: Throwable) {
                    _paymentHistory.postValue(null)
                    Log.d("Error onFailure : ", t.message!!)
                }
            })
        return getPaymentHistory
    }

    private val _getDetailPaymentBill = MutableLiveData<ApiGetdetailNota?>()
    val getDetailPaymentBill: LiveData<ApiGetdetailNota?> = _getDetailPaymentBill

    fun getDetailBill (
        idBill: String,
    ):LiveData<ApiGetdetailNota?>{
        Log.d("Debug", "Error Check")
        apiService.getDetailBillById(idBill)
            .enqueue(object : Callback<ApiGetdetailNota> {
                override fun onResponse(
                    call: Call<ApiGetdetailNota>,
                    response: Response<ApiGetdetailNota>
                ) {
                    Log.d("Debug", response.body().toString())
                    if (response.isSuccessful) {
                        val dataResponse = response.body()
                        _getDetailPaymentBill.postValue(dataResponse)
                        dataResponse?.message.let { Log.e("Response message : ", it.toString()) }
                    } else {
                        _getDetailPaymentBill.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ApiGetdetailNota>, t: Throwable) {
                    _getDetailPaymentBill.postValue(null)
                    Log.d("Error onFailure : ", t.message!!)
                }
            })
        return getDetailPaymentBill
    }

}