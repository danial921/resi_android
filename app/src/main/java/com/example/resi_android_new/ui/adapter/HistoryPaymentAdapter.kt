package com.example.resi_android_new.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resi_android_new.data.response.DetailHistoryPayment
import com.example.resi_android_new.data.response.GetPreviewHistoryPayment
import com.example.resi_android_new.databinding.FragmentHomeBinding
import com.example.resi_android_new.databinding.ItemHistoryBinding

class HistoryPaymentAdapter(private val historyPayment : List<DetailHistoryPayment>) : RecyclerView.Adapter<HistoryPaymentAdapter.ViewHolder>(){
    class ViewHolder(val  binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : DetailHistoryPayment){
            binding.history = item
            binding.tvtitle.text = item.title
            binding.tvdate.text = item.date_time
            binding.tvPrice.text = item.total
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryPaymentAdapter.ViewHolder {
        val v = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: HistoryPaymentAdapter.ViewHolder, position: Int) {
        holder.bind(historyPayment[position])
    }

    override fun getItemCount(): Int  = historyPayment.size

}