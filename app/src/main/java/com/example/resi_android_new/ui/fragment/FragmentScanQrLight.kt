package com.example.resi_android_new.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.resi_android_new.R
import com.example.resi_android_new.databinding.FragmentScanQrLightBinding
import com.example.resi_android_new.databinding.FragmentSplashscreenBinding

class FragmentScanQrLight : Fragment() {
    private lateinit var binding : FragmentScanQrLightBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScanQrLightBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionListener()
    }

    private fun setActionListener(){
        binding.apply {
            ivDarkMode.setOnClickListener{
                findNavController().navigate(R.id.action_fragmentScanQrLight_to_fragmrntScanQr)
            }
            ivBack.setOnClickListener{
                findNavController().navigate(R.id.action_global_homeFragment)
            }
        }
    }
}