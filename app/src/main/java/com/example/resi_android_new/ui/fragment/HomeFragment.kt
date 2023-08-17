package com.example.resi_android_new.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resi_android_new.R
import com.example.resi_android_new.data.dummy.DummyData
import com.example.resi_android_new.data.response.GetPreviewHistoryPayment
import com.example.resi_android_new.data.response.GetPreviewInformation
import com.example.resi_android_new.databinding.FragmentHomeBinding
import com.example.resi_android_new.ui.adapter.HistoryPaymentAdapter
import com.example.resi_android_new.ui.adapter.InformationHistoryAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getHistoryTicket()
        getInformation()
    }

    private fun getHistoryTicket() {

        val dummyData = DummyData.previewHistoryTransaction
        val historyItems: List<GetPreviewHistoryPayment> = Gson().fromJson(dummyData, object : TypeToken<List<GetPreviewHistoryPayment>>() {}.type)

        setDataToRVHistory(historyItems)
    }

    private fun setDataToRVHistory(data: List<GetPreviewHistoryPayment>){
        val adapter =  HistoryPaymentAdapter(data)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvHistory.adapter = adapter
        binding.rvHistory.layoutManager = layoutManager

    }

    private fun getInformation() {

        val dummyData = DummyData.informationData
        val historyItems: List<GetPreviewInformation> = Gson().fromJson(dummyData, object : TypeToken<List<GetPreviewInformation>>() {}.type)

        setDataToRVinformation(historyItems)
    }

    private fun setDataToRVinformation(data: List<GetPreviewInformation>){
        val adapter =  InformationHistoryAdapter(data)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvInformation.adapter = adapter
        binding.rvInformation.layoutManager = layoutManager

    }

    private fun setListener(){
        binding.apply {
            ivShowAllTransaction.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_transactionHistory)
            }
        }
    }
}