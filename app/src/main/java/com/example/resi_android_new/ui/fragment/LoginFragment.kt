package com.example.resi_android_new.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.resi_android_new.R
import com.example.resi_android_new.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
    }

    private fun setListener(){
        binding.apply {
            tvRegistNow.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }

            btnSignin.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
    }
}