package com.example.collegehub

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegehub.model.Chapter
import com.example.collegehub.model.MainDetail
import com.example.collegehub.model.Subject
import com.example.collegehub.ui.MainDetailsAdapter
import com.example.collegehub.ui.NotesAdapter
import com.example.collegehub.ui.SubjectsAdapter

@BindingAdapter("setData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Subject>?){
    val adapter = recyclerView.adapter as SubjectsAdapter
    adapter.submitList(data)
}

@BindingAdapter("setChapter")
fun bindChapterRecyclerView(recyclerView: RecyclerView, data: List<Chapter>?){
    val adapter = recyclerView.adapter as NotesAdapter
    adapter.submitList(data)
}

@BindingAdapter("setMainDetails")
fun bindMainDetailsRecyclerView(recyclerView: RecyclerView, data: List<MainDetail>){
    val adapter = recyclerView.adapter as MainDetailsAdapter
    adapter.submitList(data)
}