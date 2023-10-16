package com.example.resi_android_new.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.resi_android_new.R
import com.example.resi_android_new.databinding.FragmentKetentuanLayananBinding


class FragmentKetentuanLayanan : Fragment() {
    private lateinit var binding : FragmentKetentuanLayananBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKetentuanLayananBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionLisener()
    }

    private fun setActionLisener (){
        binding.apply {
            ivBack.setOnClickListener{
                findNavController().navigate(R.id.action_fragmentKetentuanLayanan_to_fragmentProfile)
            }
        }
    }

}