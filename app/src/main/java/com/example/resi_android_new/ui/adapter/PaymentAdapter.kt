package com.example.resi_android_new.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.resi_android_new.R
import com.example.resi_android_new.data.response.GetHistoryPayment
import com.example.resi_android_new.data.response.GetPreviewHistoryPayment
import com.example.resi_android_new.databinding.ItemHistoryBinding
import com.example.resi_android_new.databinding.ItemTransactionBinding

class PaymentAdapter (private val listpayment : List<GetHistoryPayment>) : RecyclerView.Adapter<PaymentAdapter.ViewHolder>(){
    class ViewHolder(val  binding: ItemTransactionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GetHistoryPayment) {
            binding.history = item
            binding.tvTitle.text = item.title
            binding.tvdate.text = item.date_time
            binding.tvTotal.text = item.total

            val imgResId = itemView.context.resources.getIdentifier(item.logo, "drawable", itemView.context.packageName)
            if (imgResId != 0) {
                binding.ivLogo.setImageResource(imgResId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val p = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(p)
    }

    override fun getItemCount(): Int = listpayment.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listpayment[position])
    }
}