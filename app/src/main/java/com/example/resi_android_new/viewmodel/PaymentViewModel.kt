package com.example.resi_android_new.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.resi_android_new.data.response.*
import com.example.resi_android_new.repository.PaymentRepository
import com.example.resi_android_new.repository.UserRepository
import com.example.resi_android_new.ui.adapter.PaymentAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel  @Inject constructor(private var paymentRepo : PaymentRepository) : ViewModel(){

    fun getHistoryPayment(token : String, limit : Int) : LiveData<GetHistoryPayment?> = paymentRepo.getPaymentHistory(token,limit)

    fun setChosenPaymentHistory(chosenPayment : DetailHistoryPayment) = paymentRepo.setChosenPayment(chosenPayment)

    fun getChosenPaymentHistory() : LiveData<DetailHistoryPayment?> = paymentRepo.chosenPaymentHistory

    fun clearChosenPaymentHistory() = paymentRepo.clearChosenPayment()

    fun getDetailPayment(idBill : String) : LiveData<ApiGetdetailNota?> = paymentRepo.getDetailBill(idBill)
}