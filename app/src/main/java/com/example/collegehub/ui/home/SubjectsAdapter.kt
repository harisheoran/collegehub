package com.example.collegehub.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegehub.databinding.MainScreenCardViewBinding
import com.example.collegehub.model.Subject
import com.example.collegehub.ui.onSubjectClickListener

class SubjectsAdapter(private val onSubjectClickListener: onSubjectClickListener) :
    ListAdapter<Subject, SubjectsAdapter.SubjectViewModel>(DiffCallback) {

    class SubjectViewModel(var binding: MainScreenCardViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(onSubjectClickListener: onSubjectClickListener, mySubject: Subject) {
            binding.subject = mySubject
            binding.subjectImage.setImageResource(mySubject.img)
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                onSubjectClickListener.onSubjectClick(mySubject)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewModel {
        val view = SubjectViewModel(MainScreenCardViewBinding.inflate(LayoutInflater.from(parent.context)))
        return view
    }

    override fun onBindViewHolder(holder: SubjectViewModel, position: Int) {
        val mySubject = getItem(position)
        holder.bind(onSubjectClickListener, mySubject)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Subject>() {
        override fun areItemsTheSame(oldItem: Subject, newItem: Subject): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Subject, newItem: Subject): Boolean {
            return oldItem.name == newItem.name
        }
    }
}

class ClickBehaviour(val clickfunction: (subject: Subject) -> Unit) {
    fun click(subject: Subject) = clickfunction(subject)
}