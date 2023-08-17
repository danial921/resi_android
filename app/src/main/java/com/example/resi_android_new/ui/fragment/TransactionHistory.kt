package com.example.resi_android_new.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resi_android_new.R
import com.example.resi_android_new.data.dummy.DummyData
import com.example.resi_android_new.data.response.GetHistoryPayment
import com.example.resi_android_new.data.response.GetPreviewInformation
import com.example.resi_android_new.databinding.FragmentTransactionHistoryBinding
import com.example.resi_android_new.ui.adapter.InformationHistoryAdapter
import com.example.resi_android_new.ui.adapter.PaymentAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TransactionHistory : Fragment() {
    private lateinit var binding: FragmentTransactionHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransactionHistoryBinding.inflate(inflater, container, false)
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
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
            rvTransaction.setOnClickListener {
                findNavController().navigate(R.id.action_transactionHistory_to_fragmentDetailNota)
            }
        }
    }
    private fun getTransaction() {

        val dummyData = DummyData.historyTransaction
        val transactionItems: List<GetHistoryPayment> = Gson().fromJson(dummyData, object : TypeToken<List<GetHistoryPayment>>() {}.type)

        setDataToRVinformation(transactionItems)
    }

    private fun setDataToRVinformation(data: List<GetHistoryPayment>){
        val adapter =  PaymentAdapter(data)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvTransaction.adapter = adapter
        binding.rvTransaction.layoutManager = layoutManager

    }


}