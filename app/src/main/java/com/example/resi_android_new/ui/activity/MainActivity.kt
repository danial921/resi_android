package com.example.resi_android_new.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.resi_android_new.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setBottomNavListener()
    }
}