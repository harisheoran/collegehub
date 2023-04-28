package com.example.collegehub_beta.ui.home

import android.content.Context
import android.icu.lang.UScript.ScriptUsage
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collegehub_beta.data.HomeData
import com.example.collegehub_beta.databinding.HeaderViewBinding
import com.example.collegehub_beta.databinding.HomeScreenInfoCardBinding
import com.example.collegehub_beta.databinding.HomeScreenSubjectCardBinding

class HomeScreenAdapter(val homeItemsList: List<HomeData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return homeItemsList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (homeItemsList[position]) {
            is HomeData.Subject -> 0
            is HomeData.HomeInfo -> 1
            is HomeData.Header -> 2
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    class HeaderViewHolder(val binding: HeaderViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myHeading: HomeData.Header) {
            binding.headerTitle.text = myHeading.title
            binding.executePendingBindings()
        }
    }

    class SubjectViewHolder(val binding: HomeScreenSubjectCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mySubject: HomeData.Subject) {
            binding.subjectName.text = mySubject.name
            binding.subjectImage.setImageResource(mySubject.img)
            binding.executePendingBindings()
        }
    }

    class HomeInfoViewHolder(val binding: HomeScreenInfoCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myHomeInfo: HomeData.HomeInfo) {
            binding.title.text = myHomeInfo.title
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> SubjectViewHolder(
                HomeScreenSubjectCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )

            1 -> HomeInfoViewHolder(
                HomeScreenInfoCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            2 -> HeaderViewHolder(
                HeaderViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SubjectViewHolder -> holder.bind(homeItemsList[position] as HomeData.Subject)
            is HomeInfoViewHolder -> holder.bind(homeItemsList[position] as HomeData.HomeInfo)
            is HeaderViewHolder -> holder.bind(homeItemsList[position] as HomeData.Header)
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

}