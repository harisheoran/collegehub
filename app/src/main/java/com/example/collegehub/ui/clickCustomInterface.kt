package com.example.collegehub.ui

import com.example.collegehub.model.Chapter
import com.example.collegehub.model.Subject

interface onSubjectClickListener {
    fun onSubjectClick(subject: Subject)
}

interface onChapterClickListener {
    fun onChapterClick(chapter: Chapter)
}