package com.example.resi_android_new.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resi_android_new.data.response.GetPreviewInformation
import com.example.resi_android_new.databinding.ItemInformationHistoryBinding

class InformationHistoryAdapter (private val listInformation : List<GetPreviewInformation>) : RecyclerView.Adapter<InformationHistoryAdapter.ViewHolder>(){

    class ViewHolder(val binding : ItemInformationHistoryBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(item : GetPreviewInformation){
            binding.information = item
            binding.tvtitle.text = item.title
            binding.tvDate.text = item.date_time
            binding.tvLike.text = item.like
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemInformationHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = listInformation.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listInformation[position])
    }

}