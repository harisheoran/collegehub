package com.example.collegehub.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegehub.databinding.NotesCardViewBinding
import com.example.collegehub.model.Chapter
import com.example.collegehub.model.Subject

class NotesAdapter(val myClickBehaviour: ClickBehviourChapters) :
    ListAdapter<Chapter, NotesAdapter.NotesViewHolder>(DiffCallback) {

    class NotesViewHolder(var binding: NotesCardViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickBehaviour: ClickBehviourChapters, chapter: Chapter) {
            binding.chapter = chapter
            binding.clickActionChapter = clickBehaviour
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(NotesCardViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(myClickBehaviour, currentItem)
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

class ClickBehviourChapters(val navigateToNotes: (chapter: Chapter) -> Unit) {
    fun clickActionOnChapter(chapter: Chapter) = navigateToNotes(chapter)
}