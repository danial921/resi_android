package com.example.resi_android_new.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.resi_android_new.R
import com.example.resi_android_new.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
    }

    private fun setListener(){
        binding.apply {
            btnSignup.setOnClickListener{
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
            ivBack.setOnClickListener{
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
            tvForgotPassword.setOnClickListener{
                findNavController().navigate(R.id.action_registerFragment_to_fragmentForgetPassword)
            }
        }
    }
}