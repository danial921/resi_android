package com.example.resi_android_new.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resi_android_new.data.response.*
import com.example.resi_android_new.databinding.ItemDetailNotaBinding
import com.example.resi_android_new.databinding.ItemInformationHistoryBinding

class DetailNotaAdapter (private val listBillDetail : List<ApiProductdetail>) : RecyclerView.Adapter<DetailNotaAdapter.ViewHolder>() {
    class ViewHolder(val binding : ItemDetailNotaBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : ApiProductdetail){
            Log.d("ViewHolder", "Binding data: ${item}")
            binding.detailProduct = item
            binding.tvName.text = item.name
            binding.tvQty.text = item.quantity.toString()
            binding.tvPrice.text = item.price.toString()
            binding.tvTotalPrice.text = item.total.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemDetailNotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = listBillDetail.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listBillDetail[position])
    }
}