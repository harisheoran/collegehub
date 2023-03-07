package com.example.collegehub.ui

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.collegehub.R
import com.example.collegehub.model.Subject

class MainAdapter(private val context: Context, private val dataset: List<Subject>) :
    RecyclerView.Adapter<MainAdapter.SubjectsViewHolder>() {

    class SubjectsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.subject_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.subject_list, parent, false)
        return SubjectsViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: SubjectsViewHolder, position: Int) {
        val subject = dataset[position]
        holder.textView.text = context.resources.getString(subject.name)
    }
}