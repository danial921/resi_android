package com.example.resi_android_new.ui.fragment

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.resi_android_new.R
import com.example.resi_android_new.data.Constant
import com.example.resi_android_new.databinding.FragmentScanQrBinding
import com.example.resi_android_new.databinding.FragmentScanQrLightBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Suppress("UNCHECKED_CAST", "SetTextI18n")
@RequiresApi(Build.VERSION_CODES.M)
class FragmentScanQr : Fragment() {
    private lateinit var binding : FragmentScanQrBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScanQrBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionListener()
        setQrCode()
        setTextBinidng()
    }

    private fun setTextBinidng(){
        val name = requireActivity().getSharedPreferences(Constant.dataUser, Context.MODE_PRIVATE).getString("name", null)
        val email = requireActivity().getSharedPreferences(Constant.dataUser, Context.MODE_PRIVATE).getString("email", null)
        val phoneNumber = requireActivity().getSharedPreferences(Constant.dataUser, Context.MODE_PRIVATE).getString("phoneNumber", null)

        binding.tvProfile.text = name
        binding.tvEmail.text = email
        binding.IdCustomer.setText(phoneNumber)
    }
    private fun setActionListener(){
        binding.apply {
            ivLightMode.setOnClickListener{
                findNavController().navigate(R.id.action_fragmrntScanQr_to_fragmentScanQrLight)
            }
            ivBack.setOnClickListener{
                findNavController().navigate(R.id.action_global_homeFragment)
            }
        }
    }

    fun setQrCode() {
        val idUser = requireActivity().getSharedPreferences(Constant.dataUser, Context.MODE_PRIVATE).getString("idUser",null)
        Log.d("QRCodeDebug", "ID User: $idUser")
        val qrCodeBitmap = idUser?.let { encodeQrAsBitmap(it, 1000, 1000) }
        binding.ivQrCode.setImageBitmap(qrCodeBitmap)
    }


    fun encodeQrAsBitmap(str: String, width: Int, height: Int): Bitmap? {
        val result: BitMatrix
        val hints = hashMapOf<EncodeHintType, Any>()
        hints[EncodeHintType.MARGIN] = 1  // Setel margin ke nilai yang diinginkan. Nilai 1 biasanya adalah yang terkecil yang dianjurkan.

        try {
            result = MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, width, height, hints)
        } catch (iae: IllegalArgumentException) {
            // Unsupported format
            return null
        }

        val w = result.width
        val h = result.height
        val pixels = IntArray(w * h)
        for (y in 0 until h) {
            val offset = y * w
            for (x in 0 until w) {
                pixels[offset + x] = if (result.get(x, y)) Color.BLACK else Color.WHITE
            }
        }
        val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        bitmap.setPixels(pixels, 0, width, 0, 0, w, h)
        return bitmap
    }
}