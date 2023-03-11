package com.example.collegehub.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegehub.databinding.MainScreenCardViewBinding
import com.example.collegehub.model.Subject

class SubjectsAdapter(val subjectclickBehaviour: ClickBehaviour): ListAdapter<Subject, SubjectsAdapter.SubjectViewModel>(DiffCallback) {

    class SubjectViewModel(var binding: MainScreenCardViewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind( clickfunction: ClickBehaviour,mySubject: Subject){
            binding.subject = mySubject
            binding.clickAction = clickfunction
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewModel {
        val view = SubjectViewModel(MainScreenCardViewBinding.inflate(LayoutInflater.from(parent.context)))
        return view
    }

    override fun onBindViewHolder(holder: SubjectsAdapter.SubjectViewModel, position: Int) {
        val mySubject = getItem(position)
        holder.bind(subjectclickBehaviour, mySubject)
    }
    companion object DiffCallback : DiffUtil.ItemCallback<Subject>() {
        override fun areItemsTheSame(oldItem: Subject, newItem: Subject): Boolean {
            return oldItem.name == newItem.name && oldItem.img == newItem.img
        }
        override fun areContentsTheSame(oldItem: Subject, newItem: Subject): Boolean {
            return oldItem.name == newItem.name && oldItem.img == newItem.img
        }
    }
}

class ClickBehaviour(val clickfunction: (subject: Subject) -> Unit){
    fun click(subject: Subject) = clickfunction(subject)
}