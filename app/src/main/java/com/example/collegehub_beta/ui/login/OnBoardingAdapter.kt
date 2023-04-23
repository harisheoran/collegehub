package com.example.collegehub_beta.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.collegehub_beta.databinding.OnboardingItemBinding

data class OnBoardingItem(
    val title: String,
    val description: String,
    val icon: String
)

class OnBoardingAdapter(val item: List<OnBoardingItem>) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    class OnBoardingViewHolder(var binding: OnboardingItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myItem: OnBoardingItem) {
            binding.textTitle.text = myItem.title
            binding.textDescription.text = myItem.description
            binding.imageIcon.imageAssetsFolder = "assets"
            binding.imageIcon.setAnimation(myItem.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(OnboardingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(
            item[position]
        )
    }

}