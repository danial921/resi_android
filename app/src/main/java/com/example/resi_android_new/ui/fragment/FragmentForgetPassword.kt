package com.example.resi_android_new.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.resi_android_new.R
import com.example.resi_android_new.databinding.FragmentForgetPasswordBinding

class FragmentForgetPassword : Fragment() {
    private lateinit var binding: FragmentForgetPasswordBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentForgetPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
    }

    private fun setListener(){
        binding.apply {
            ctaResetPassword.setOnClickListener{
//                resetPassword()
            }
            ivBack.setOnClickListener{
                findNavController().navigate(R.id.action_global_loginFragment)
            }
            btnLogin.setOnClickListener{
                findNavController().navigate(R.id.action_global_fragmentForgetPassword)
            }
            btnRegister.setOnClickListener{
                findNavController().navigate(R.id.action_global_loginFragment)
            }
        }
    }
}