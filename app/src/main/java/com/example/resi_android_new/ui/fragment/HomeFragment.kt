package com.example.resi_android_new.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resi_android_new.R
import com.example.resi_android_new.data.response.GetPreviewHistoryPayment
import com.example.resi_android_new.databinding.FragmentHomeBinding
import com.example.resi_android_new.databinding.FragmentLoginBinding
import com.example.resi_android_new.ui.adapter.HistoryPaymentAdapter
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

        setRv()
        getHistoryTicket()
    }

    private fun setRv(){
        val recyclerView: RecyclerView = binding.rvInvormation
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun getHistoryTicket() {
        val dummyData = """
            [
              {
                "title": "Indomaret Keputih No.24",
                "date_time": "Minggu, 26 Juni 2023",
                "total": "Rp. 35.610,00"
              },
              {
                "title": "Hympermart Manyar Surabaya",
                "date_time": "Sabtu, 25 Juni 2023",
                "total": "Rp. 3.005.610,00"
              },
              {
                "title": "Starbuck Basuki Rahmat",
                "date_time": "Jumat, 24 Juni 2023",
                "total": "Rp. 65.000,00"
              },
              {
                "title": "Indomaret Keputih No.24",
                "date_time": "Minggu, 26 Juni 2023",
                "total": "Rp. 35.610,00"
              },
              {
                "title": "Hympermart Manyar Surabaya",
                "date_time": "Sabtu, 25 Juni 2023",
                "total": "Rp. 3.005.610,00"
              }
            ]

        """.trimIndent()
        val ticketItems: List<GetPreviewHistoryPayment> = Gson().fromJson(dummyData, object : TypeToken<List<GetPreviewHistoryPayment>>() {}.type)

        setDataToRecView(ticketItems)
    }

    private fun setDataToRecView(data: List<GetPreviewHistoryPayment>){
        val adapter =  HistoryPaymentAdapter(data)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvInvormation.adapter = adapter
        binding.rvInvormation.layoutManager = layoutManager

    }
}