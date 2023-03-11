package com.example.collegehub.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegehub.data.Chapters
import com.example.collegehub.data.Subjects
import kotlinx.coroutines.launch

class HubViewModel : ViewModel() {
    private val _subject = MutableLiveData<List<Subject>>()
    val subject: LiveData<List<Subject>> = _subject

    private val _chapter = MutableLiveData<List<Chapter>>()
    val chapter: LiveData<List<Chapter>> = _chapter

    init {
        getSubjectList()
    }


    private fun getSubjectList() {
        viewModelScope.launch {
            _subject.value = Subjects().loadSubjectList()
            _chapter.value = Chapters().loadChapter()
        }
    }
}



