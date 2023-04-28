package com.example.collegehub_beta.utils

import com.example.collegehub_beta.model.Chapter
import com.example.collegehub_beta.model.Subject

interface onSubjectClickListener {
    fun onSubjectClick(subject: Subject)
}

interface onChapterClickListener {
    fun onChapterClick(chapter: Chapter)
}
