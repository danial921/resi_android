package com.example.resi_android_new.ui.fragment

import android.annotation.SuppressLint
import android.content.SharedPreferences
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
import com.example.resi_android_new.data.Constant.dataUser
import com.example.resi_android_new.data.dummy.DummyData
import com.example.resi_android_new.data.response.*
import com.example.resi_android_new.databinding.FragmentDetailNotaBinding
import com.example.resi_android_new.ui.adapter.DetailNotaAdapter
import com.example.resi_android_new.ui.adapter.HistoryPaymentAdapter
import com.example.resi_android_new.viewmodel.PaymentViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@RequiresApi(Build.VERSION_CODES.O)
class FragmentDetailNota : Fragment() {
    private lateinit var binding : FragmentDetailNotaBinding
    private lateinit var clickedPayment : DetailHistoryPayment
    private lateinit var paymentVM : PaymentViewModel
    private lateinit var sharedPrefs : SharedPreferences

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailNotaBinding.inflate(inflater, container, false)
        sharedPrefs = requireActivity().getSharedPreferences(dataUser, 0)
        paymentVM = ViewModelProvider(requireActivity()).get(PaymentViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataFromBundle()
        setOnClicListener()

    }
    private fun setOnClicListener(){
        binding.apply {
            ibBackButton.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentDetailNota_to_transactionHistory)
            }
        }
    }

    private fun getDataFromBundle() {
        paymentVM.getChosenPaymentHistory().observe(viewLifecycleOwner){
            if (it != null) {
                clickedPayment = it
                Log.d("clicked ticket", clickedPayment.toString())
                getBillData()
            }
        }
    }

    private fun getBillData(){
        paymentVM.getDetailPayment(clickedPayment.id).observe(viewLifecycleOwner){
            if (it != null) {
                Log.d("Detail Bill Result",it.toString())
                showData(it.detaiBill)
            }
        }
    }

    private fun showData(dataproduct: ApiDetaiBill){

        binding.tvShopName.text = dataproduct.ShopName
        binding.tvAdrress.text = dataproduct.shopAdress
        binding.tvphoneNumber.text = dataproduct.PhoneNumber


        binding.tvDiscount.text = dataproduct.diskon.toString()
        binding.tvSellPrice.text = dataproduct.hargaJual.toString()
        binding.tvTotalPrice.text = dataproduct.total.toString()
        binding.tvTunai.text = dataproduct.tunai.toString()
        binding.tvReturn.text = dataproduct.kembalian.toString()


        setDataToRVDetailNota(dataproduct.productdetails)
    }


    private fun setDataToRVDetailNota(data: List<ApiProductdetail>){
        val adapter =  DetailNotaAdapter(data)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvDetailNota.adapter = adapter
        binding.rvDetailNota.layoutManager = layoutManager

    }

}