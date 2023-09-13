package com.example.resi_android_new.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resi_android_new.R
import com.example.resi_android_new.data.response.DetailHistoryPayment
import com.example.resi_android_new.data.response.GetHistoryPayment
import com.example.resi_android_new.data.response.GetPreviewHistoryPayment
import com.example.resi_android_new.databinding.ItemHistoryBinding
import com.example.resi_android_new.databinding.ItemTransactionBinding

class PaymentAdapter (private val listpayment : List<DetailHistoryPayment>) : RecyclerView.Adapter<PaymentAdapter.ViewHolder>(){
    var onClick: ((DetailHistoryPayment) -> Unit)? = null
    class ViewHolder(val  binding: ItemTransactionBinding,  private var onClick: ((DetailHistoryPayment) -> Unit)?) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SimpleDateFormat", "SetTextI18n")
        fun bind(item: DetailHistoryPayment) {
            binding.history = item
            binding.tvTitle.text = item.title
            binding.tvdate.text = item.date_time
            binding.priceTotal.text = item.total



            val imageUrl = "https://apiresi.happyhosting.my.id/api/storage/${item.logo}" // Asumsikan "url" adalah URL dasar Anda.
            Glide.with(itemView.context)
                .load(imageUrl)
                .into(binding.ivLogo)
            binding.cardHistory.setOnClickListener {
                onClick?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val p = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(p, onClick)
    }

    override fun getItemCount(): Int = listpayment.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listpayment[position])
    }
}