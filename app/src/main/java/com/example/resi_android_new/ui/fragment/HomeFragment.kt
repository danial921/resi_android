package com.example.resi_android_new.ui.fragment

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
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
import com.example.resi_android_new.databinding.FragmentHomeBinding
import com.example.resi_android_new.ui.activity.MainActivity
import com.example.resi_android_new.ui.adapter.HistoryPaymentAdapter
import com.example.resi_android_new.ui.adapter.InformationHistoryAdapter
import com.example.resi_android_new.viewmodel.PaymentViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Suppress("UNCHECKED_CAST", "SetTextI18n")
@RequiresApi(Build.VERSION_CODES.M)
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var paymentVM : PaymentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        paymentVM = ViewModelProvider(requireActivity()).get(PaymentViewModel::class.java)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).binding.bottomNavbar.visibility = View.VISIBLE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getHistoryPayment()
        getInformation()
    }

    private fun getHistoryPayment() {

        val token = requireActivity().getSharedPreferences(Constant.dataUser, Context.MODE_PRIVATE).getString("token", null)
        if (token != null) {
            Log.d("Debug", "Home Check")
            paymentVM.getHistoryPayment("Bearer $token", 6).observe(viewLifecycleOwner){
                if (it != null) {
                    Log.d("Bill Result",it.bill.toString())
                    setDataToRVHistory(it.bill)
                }
            }
        }
    }

    private fun setDataToRVHistory(data: List<DetailHistoryPayment>){
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
            btnHistory.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_transactionHistory)
            }
            btnFAQ.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_fragmentFaq)
            }
        }
    }
}