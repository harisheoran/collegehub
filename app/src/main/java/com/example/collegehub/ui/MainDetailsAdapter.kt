package com.example.collegehub.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegehub.data.MainDetails
import com.example.collegehub.databinding.MainDetailsCardBinding
import com.example.collegehub.model.MainDetail
import com.example.collegehub.model.Subject

class MainDetailsAdapter: ListAdapter<MainDetail, MainDetailsAdapter.MainDetailsViewHolder>(DiffCallback) {
    class MainDetailsViewHolder(var binding: MainDetailsCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(myDetail: MainDetail){
            binding.mainDetail = myDetail
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainDetailsViewHolder {
        val view = MainDetailsViewHolder(MainDetailsCardBinding.inflate(LayoutInflater.from(parent.context)))
        return view
    }

    override fun onBindViewHolder(holder: MainDetailsViewHolder, position: Int) {
        val myDetail = getItem(position)
        holder.bind(myDetail)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MainDetail>() {
        override fun areItemsTheSame(oldItem: MainDetail, newItem: MainDetail): Boolean {
            return oldItem.title == newItem.title
        }
        override fun areContentsTheSame(oldItem: MainDetail, newItem: MainDetail): Boolean {
            return oldItem.title == newItem.title
        }
    }

}