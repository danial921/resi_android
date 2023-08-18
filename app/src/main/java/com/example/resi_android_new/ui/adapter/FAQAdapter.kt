package com.example.resi_android_new.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resi_android_new.data.response.DetailProduct
import com.example.resi_android_new.data.response.GetFAQInformation
import com.example.resi_android_new.databinding.ItemDetailNotaBinding
import com.example.resi_android_new.databinding.ItemFaqBinding
import kotlin.math.log

class FAQAdapter (private val listFAQ : List<GetFAQInformation>) : RecyclerView.Adapter<FAQAdapter.ViewHolder>(){

    class ViewHolder(val binding : ItemFaqBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : GetFAQInformation){

            binding.faq = item
            binding.tvTitle.text = item.title
            binding.tvContent.text = item.content

            binding.cardContent.visibility = View.GONE

            binding.cardView.setOnClickListener {
                if (binding.cardContent.visibility == View.VISIBLE) {
                    binding.cardContent.visibility = View.GONE
                } else {
                    binding.cardContent.visibility = View.VISIBLE
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemFaqBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = listFAQ.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listFAQ[position])
    }
}