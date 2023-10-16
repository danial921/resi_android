package com.example.resi_android_new.ui.fragment

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resi_android_new.R
import com.example.resi_android_new.data.Constant
import com.example.resi_android_new.data.dummy.DummyData
import com.example.resi_android_new.data.response.DetailHistoryPayment
import com.example.resi_android_new.data.response.GetHistoryPayment
import com.example.resi_android_new.data.response.GetPreviewHistoryPayment
import com.example.resi_android_new.data.response.GetPreviewInformation
import com.example.resi_android_new.databinding.FragmentTransactionHistoryBinding
import com.example.resi_android_new.ui.adapter.InformationHistoryAdapter
import com.example.resi_android_new.ui.adapter.PaymentAdapter
import com.example.resi_android_new.viewmodel.PaymentViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Suppress("UNCHECKED_CAST", "SetTextI18n")
@RequiresApi(Build.VERSION_CODES.M)
class TransactionHistory : Fragment() {
    private lateinit var binding: FragmentTransactionHistoryBinding
    private lateinit var paymentVM : PaymentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransactionHistoryBinding.inflate(inflater, container, false)
        paymentVM = ViewModelProvider(requireActivity()).get(PaymentViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionListener()
        getTransaction()
    }

    private fun setActionListener(){
        binding.apply {
            ivBackIcon.setOnClickListener{
                 findNavController().navigate(R.id.action_transactionHistory_to_homeFragment)
            }
            rvTransaction.setOnClickListener {
                findNavController().navigate(R.id.action_transactionHistory_to_fragmentDetailNota)
            }
        }
    }
    private fun getTransaction() {
        val token = requireActivity().getSharedPreferences(Constant.dataUser, Context.MODE_PRIVATE).getString("token", null)
        if (token != null) {
            Log.d("Debug", "Home Check")
            paymentVM.getHistoryPayment("Bearer $token", 0).observe(viewLifecycleOwner){
                if (it != null) {
                    Log.d("Bill Result",it.bill.toString())
                    setDataToRVinformation(it.bill)
                }
            }
        }
    }

    private fun setDataToRVinformation(data: List<DetailHistoryPayment>){
        val adapter =  PaymentAdapter(data)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.rvTransaction.adapter = adapter
        binding.rvTransaction.layoutManager = layoutManager

        adapter.onClick = {
            paymentVM.clearChosenPaymentHistory()
            paymentVM.setChosenPaymentHistory(it)

            val bundle = Bundle().apply {
                putSerializable("payment_history_detail", it)
            }

            findNavController().navigate(R.id.action_transactionHistory_to_fragmentDetailNota, bundle)
        }
    }
}