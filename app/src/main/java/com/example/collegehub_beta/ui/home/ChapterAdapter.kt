package com.example.collegehub_beta.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegehub_beta.databinding.ChapterCardBinding
import com.example.collegehub_beta.model.Chapter
import com.example.collegehub_beta.utils.onChapterClickListener

class ChapterAdapter(val onChapterClick: onChapterClickListener) :
    ListAdapter<Chapter, ChapterAdapter.ChapterViewHolder>(DiffCallback) {

    class ChapterViewHolder(var binding: ChapterCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onChapterClick: onChapterClickListener, chapter: Chapter) {

            binding.root.setOnClickListener {
                onChapterClick.onChapterClick(chapter)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        return ChapterViewHolder(ChapterCardBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(onChapterClick, currentItem)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Chapter>() {
        override fun areItemsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
            return oldItem.name == newItem.name
        }
    }
}