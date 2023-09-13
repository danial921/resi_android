package com.example.resi_android_new.ui.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.resi_android_new.R
import com.example.resi_android_new.databinding.FragmentRegisterBinding
import com.example.resi_android_new.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var userVM : UserViewModel
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        userVM = ViewModelProvider(this).get(UserViewModel::class.java)
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
//                findNavController().navigate(R.id.action_global_loginFragment)
                signUpUser()
            }
            ivBack.setOnClickListener{
                findNavController().navigate(R.id.action_global_loginFragment)
            }
            tvForgotPassword.setOnClickListener{
                findNavController().navigate(R.id.action_global_fragmentForgetPassword)
            }
            tvLoginSekarang.setOnClickListener{
                findNavController().navigate(R.id.action_global_loginFragment)
            }
        }
    }

    private fun signUpUser(){
        val nama = binding.namaInput.text.toString()
        val email = binding.emailInput.text.toString()
        val nomerTelefon = binding.nomerTelefonInput.text.toString()
        val password = binding.passwordInput.text.toString()
        if (validateInput()) {
            observeRegisterResult(nama,email, nomerTelefon, password)
        }
    }

    private fun nameIsEmpty(): Boolean {
        return binding.namaInput.text.toString().isEmpty()
    }

    private fun emailIsEmpty(): Boolean {
        return binding.emailInput.text.toString().isEmpty()
    }

    private fun passwordNotMatch(): Boolean {
        return binding.passwordInput.text.toString() == binding.confirmPasswordInput.text.toString()
    }

    private fun phoneIsEmpty(): Boolean {
        return binding.nomerTelefonInput.text.toString().isEmpty()
    }

    private fun confirmPasswordIsEmpty(): Boolean {
        return binding.confirmPasswordInput.text.toString().isEmpty()
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    private fun passwordIsEmpty(): Boolean {
        return binding.passwordInput.text.toString().isEmpty()
    }
    private fun validateInput(): Boolean {
        var isValid = true
        binding.apply {
            namaInput.setOnFocusChangeListener(object : View.OnFocusChangeListener {
                override fun onFocusChange(v: View?, hasFocus: Boolean) {
                    if (!hasFocus) {
                        if (nameIsEmpty()) {
                            namaInput.error = "Nama Tidak Boleh Kosong"
                            isValid = false
                        }
                    }
                }
            })
            emailInput.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
                if (!hasFocus) {
                    if (emailIsEmpty()) {
                        emailInput.error = "Email tidak boleh kosong"
                        isValid = false
                    }
                }
            }
            emailInput.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    if (!isValidEmail(s.toString())) {
                        isValid = false
                        emailInput.error = "Email tidak valid"
                    }
                }
            })
            passwordInput.setOnFocusChangeListener(object : View.OnFocusChangeListener {
                override fun onFocusChange(v: View?, hasFocus: Boolean) {
                    if (!hasFocus) {
                        if (passwordIsEmpty()) {
                            passwordInput.error = "Password tidak boleh kosong"
                            isValid = false
                        }
                    }
                }
            })
            nomerTelefonInput.setOnFocusChangeListener(object : View.OnFocusChangeListener {
                override fun onFocusChange(v: View?, hasFocus: Boolean) {
                    if (!hasFocus) {
                        if (phoneIsEmpty()) {
                            nomerTelefonInput.error = "Nomer Telefon Boleh Kosong"
                            isValid = false
                        }
                    }
                }
            })
            confirmPasswordInput.setOnFocusChangeListener(object : View.OnFocusChangeListener {
                override fun onFocusChange(v: View?, hasFocus: Boolean) {
                    if (!hasFocus) {
                        if (passwordNotMatch()) {
                            confirmPasswordInput.error = "Password Tidak Sama"
                            isValid = false
                        }
                    }
                }
            })
        }
        return isValid
    }

    private fun observeRegisterResult(name: String, email: String, phoneNumber :String, pass :String) {
//        showLoading(true)
        userVM.registerUser(name, email, phoneNumber, pass).observe(viewLifecycleOwner) { it ->
            if (it?.status == true) {
                Toast.makeText(
                    requireContext(),
                    "berhasil membuat akun",
                    Toast.LENGTH_SHORT
                ).show()
                findNavController().navigate(R.id.action_global_loginFragment)
            }

            else if(it?.status == false) {
//                userVM.getRegisterErrorMessage().observe(viewLifecycleOwner) {
//                    showLoading(false)
                    if (it.message.contains("email already use")) {
                        Toast.makeText(
                            requireContext(),
                            "email sudah digunakan",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else {
                        Toast.makeText(
                            requireContext(),
                            "gagal membuat akun",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
//                }
            }
        }
    }
}