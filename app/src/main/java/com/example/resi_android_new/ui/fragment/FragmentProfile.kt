package com.example.resi_android_new.ui.fragment

import android.app.AlertDialog
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.recreate
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.fragment.findNavController
import com.example.resi_android_new.R
import com.example.resi_android_new.data.Constant.dataUser
import com.example.resi_android_new.databinding.FragmentProfileBinding
import java.util.Locale


class FragmentProfile : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        sharedPrefs = requireActivity().getSharedPreferences(dataUser, 0)
        editor = sharedPrefs.edit()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
    }

    private fun setListener() {
        binding.apply {
            btnlogout.setOnClickListener {
                logoutAction()
            }
            ivBtnLangEn.setOnClickListener{
                setLangId()
            }
            ivBtnlangId.setOnClickListener{
                setLangEn()
            }
        }
    }

    private fun setLangId(){
        binding.ivBtnLangEn.visibility = View.GONE
        binding.ivBtnlangId.visibility = View.VISIBLE

        val newLocale = Locale("id")
        Locale.setDefault(newLocale)
        val configuration = resources.configuration
        configuration.setLocale(newLocale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
        requireActivity().recreate()
    }

    private fun setLangEn(){
        binding.ivBtnLangEn.visibility = View.VISIBLE
        binding.ivBtnlangId.visibility = View.GONE

        val newLocale = Locale("en")
        Locale.setDefault(newLocale)
        val configuration = resources.configuration
        configuration.setLocale(newLocale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
        requireActivity().recreate()
    }
    private fun logoutAction() {
        val alert = AlertDialog.Builder(requireContext())
        alert.apply {
            setTitle("Logout")
            setMessage("Apakah anda yakin ingin logout?")
            setPositiveButton("Ya") { dialog, _ ->
                Toast.makeText(requireContext(), "Logout Berhasil", Toast.LENGTH_SHORT).show()
                val editor = sharedPrefs.edit()
                editor.clear()
                editor.apply()
                findNavController().navigate(R.id.action_global_loginFragment)
                dialog.dismiss()
            }
            setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
            }
        }
        alert.create().show()
    }
}
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // Mencari tombol dalam layout activity_main.xml
////        val button = findViewById<Button>(R.id.button)
//
////        button.setOnClickListener {
////            // Tambahkan tindakan yang dijalankan saat tombol diklik di sini
////        }
//    }
//}



