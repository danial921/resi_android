package com.example.resi_android_new.ui.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.resi_android_new.ui.activity.MainActivity
import com.example.resi_android_new.R
import com.example.resi_android_new.data.Constant.dataUser
import com.example.resi_android_new.databinding.FragmentLoginBinding
import com.example.resi_android_new.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    private lateinit var userVM : UserViewModel
    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        userVM = ViewModelProvider(this).get(UserViewModel::class.java)
        sharedPrefs = requireActivity().getSharedPreferences(dataUser, 0)
        editor = sharedPrefs.edit()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }
    override fun onResume() {
        super.onResume()
        (activity as MainActivity).binding.bottomNavbar.visibility = View.GONE
    }

    private fun setListener(){
        binding.apply {
            tvRegistNow.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
            tvForgotPassword.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_fragmentForgetPassword)
            }
            btnSignin.setOnClickListener {
                signInUser()
            }
        }
    }

    private fun signInUser() {
        val email = binding.emailInput.text.toString()
        val pass = binding.passwordInput.text.toString()
        if (validateInput()) {
            observeLoginResult(email, pass)
        }
    }

    private fun emailIsEmpty(): Boolean {
        return binding.emailInput.text.toString().isEmpty()
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
        }
        return isValid
    }

    private fun observeLoginResult(email: String, pass: String) {
//        showLoading(true)
        userVM.loginUser(email, pass).observe(viewLifecycleOwner) { it ->
            if (it?.status == true) {
//                showLoading(false)
                saveUserToSharedPref(
                    it.uuid,
                    it.name,
                    it.email,
                    it.phoneNumber,
                    it.accessToken)
            } else {
                userVM.getLoginErrorMessage().observe(viewLifecycleOwner) {
//                    showLoading(false)
                    val errMessage = it
                    if (errMessage.contains("Unauthorized")) {
                        Toast.makeText(
                            requireContext(),
                            "email atau password belum terdaftar",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (errMessage.contains("Email does not exist")) {
                        Toast.makeText(
                            requireContext(),
                            "Silahkan registrasi terlebih dahulu",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (errMessage.contains("Email not verified, check your email!")) {
                        Toast.makeText(
                            requireContext(),
                            "Email belum terverifikasi",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (errMessage.contains("Password is incorrect")) {
                        Toast.makeText(context, "Email atau password salah", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    private fun saveUserToSharedPref(idUser : String, name : String, email: String, phoneNumber: String , token : String){
        with(editor) {
            putString("token", token)
            putString("phoneNumber", phoneNumber)
            putString("email", email)
            putString("idUser", idUser)
            putString("name", name)
            putBoolean("isLogin", true)
            putBoolean("isValidToken", true)
            apply()
        }
        gotoHome()
    }

    private fun gotoHome() {
        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }
}