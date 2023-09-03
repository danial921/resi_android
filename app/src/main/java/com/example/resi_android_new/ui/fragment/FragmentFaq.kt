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
import com.example.resi_android_new.data.response.GetFAQInformation
import com.example.resi_android_new.data.response.GetPreviewHistoryPayment
import com.example.resi_android_new.databinding.FragmentFaqBinding
import com.example.resi_android_new.databinding.FragmentHomeBinding
import com.example.resi_android_new.ui.adapter.FAQAdapter
import com.example.resi_android_new.ui.adapter.HistoryPaymentAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FragmentFaq : Fragment() {

    private lateinit var binding : FragmentFaqBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFaqBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getHistoryFAQ()
        setActionLisener()
    }
    private fun setActionLisener(){
        binding.apply {
            ivBack.setOnClickListener{
                findNavController().navigate(R.id.action_global_homeFragment)
            }
        }
    }
    private fun getHistoryFAQ() {

        val dummyData = DummyData.FAQItem
        val faqItems: List<GetFAQInformation> = Gson().fromJson(dummyData, object : TypeToken<List<GetFAQInformation>>() {}.type)

        setDataToRVFAQ(faqItems)
    }

    private fun setDataToRVFAQ(data: List<GetFAQInformation>){
        val adapter =  FAQAdapter(data)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvFAQ.adapter = adapter
        binding.rvFAQ.layoutManager = layoutManager

    }

}