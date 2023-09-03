package com.example.resi_android_new.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.resi_android_new.R
import com.example.resi_android_new.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNavListener()
    }
    private fun setBottomNavListener () {
        binding.apply {
            idBeranda.setOnClickListener{
                Navigation.findNavController(this@MainActivity,R.id.fragmentContainer).navigate(R.id.action_global_homeFragment)
            }
            idProfile.setOnClickListener{
                Navigation.findNavController(this@MainActivity,R.id.fragmentContainer).navigate(R.id.action_global_fragmentProfile)
            }
            ibScanQR.setOnClickListener{
                Navigation.findNavController(this@MainActivity,R.id.fragmentContainer).navigate(R.id.action_global_fragmrntScanQr)
            }
        }
    }
}