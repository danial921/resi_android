package com.example.resi_android_new.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.resi_android_new.R
import com.example.resi_android_new.data.Constant
import com.example.resi_android_new.data.Constant.initApp
import com.example.resi_android_new.databinding.FragmentSplashscreenBinding
import com.example.resi_android_new.ui.activity.MainActivity


class FragmentSplashscreen : Fragment() {
    private lateinit var binding : FragmentSplashscreenBinding
    private lateinit var sharedPref : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashscreenBinding.inflate(inflater,container,false)
        sharedPref = requireActivity().getSharedPreferences(initApp, Context.MODE_PRIVATE)
        editor = sharedPref.edit()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).binding.bottomNavbar.visibility = View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        check jwt token first run
        Handler(Looper.myLooper()!!).postDelayed({
            val token = requireActivity().getSharedPreferences(Constant.dataUser, Context.MODE_PRIVATE).getString("token", null)
            if (sharedPref.getBoolean("firstRun",true)) {
                editor.putBoolean("firstRun", false)
                editor.apply()
                findNavController().navigate(R.id.action_fragmentSplashscreen_to_fragmentSplashScreen1)
            }else if (token != null) {
                findNavController().navigate(R.id.action_global_homeFragment)
            }
            else{
                findNavController().navigate(R.id.action_fragmentSplashscreen_to_loginFragment)
            }
        },1500)
    }

}