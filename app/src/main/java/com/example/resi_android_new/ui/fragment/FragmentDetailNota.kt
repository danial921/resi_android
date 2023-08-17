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
import com.example.resi_android_new.data.response.DetailProduct
import com.example.resi_android_new.data.response.GetDetailPayment
import com.example.resi_android_new.data.response.GetPreviewHistoryPayment
import com.example.resi_android_new.databinding.FragmentDetailNotaBinding
import com.example.resi_android_new.ui.adapter.DetailNotaAdapter
import com.example.resi_android_new.ui.adapter.HistoryPaymentAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FragmentDetailNota : Fragment() {
    private lateinit var binding : FragmentDetailNotaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailNotaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showData()
    }

    private fun showData(){
        val dummyData = DummyData.detailPayment
        val detailItem: GetDetailPayment = Gson().fromJson(dummyData, object : TypeToken<GetDetailPayment>() {}.type)

        binding.tvShopName.text = detailItem.shop_name
        binding.tvAdrress.text = detailItem.shop_adress
        binding.tvphoneNumber.text = detailItem.shop_name


        binding.tvDiscount.text = detailItem.discount
        binding.tvSellPrice.text = detailItem.seller_price
        binding.tvTotalPrice.text = detailItem.total
        binding.tvTunai.text = detailItem.cash
        binding.tvReturn.text = detailItem.kembalian


        setDataToRVDetailNota(detailItem.product)
    }


    private fun setDataToRVDetailNota(data: List<DetailProduct>){
        val adapter =  DetailNotaAdapter(data)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvDetailNota.adapter = adapter
        binding.rvDetailNota.layoutManager = layoutManager

    }

}