package com.example.resi_android_new.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resi_android_new.data.response.DetailProduct
import com.example.resi_android_new.data.response.GetDetailPayment
import com.example.resi_android_new.data.response.GetPreviewInformation
import com.example.resi_android_new.databinding.ItemDetailNotaBinding
import com.example.resi_android_new.databinding.ItemInformationHistoryBinding

class DetailNotaAdapter (private val listPromo : List<DetailProduct>) : RecyclerView.Adapter<DetailNotaAdapter.ViewHolder>() {
    class ViewHolder(val binding : ItemDetailNotaBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : DetailProduct){
            binding.detailProduct = item
            binding.tvName.text = item.name
            binding.tvQty.text = item.quantity
            binding.tvPrice.text = item.price
            binding.tvTotalPrice.text = item.total
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemDetailNotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = listPromo.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listPromo[position])
    }
}