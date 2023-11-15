package com.sparrowbit.collegehub.ui.loginui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sparrowbit.collegehub.databinding.OnboardingItemBinding

data class onBoardingItems(
    val title: String,
    val description: String,
    val icon: String
)

class OnBoardingAdapter(val item: List<onBoardingItems>) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    class OnBoardingViewHolder(var binding: OnboardingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myItem: onBoardingItems) {
            binding.textTitle.text = myItem.title
            binding.textDescription.text = myItem.description
            binding.imageSlideIcon.imageAssetsFolder = "assets"
            binding.imageSlideIcon.setAnimation(myItem.icon)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardingViewHolder {
        val view =
            OnBoardingViewHolder(
                OnboardingItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        return view
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(item[position])
    }

}