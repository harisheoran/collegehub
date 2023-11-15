package com.sparrowbit.collegehub.ui

import com.sparrowbit.collegehub.model.Chapter
import com.sparrowbit.collegehub.model.Subject

interface onSubjectClickListener {
    fun onSubjectClick(subject: Subject)
}

interface onChapterClickListener {
    fun onChapterClick(chapter: Chapter)
}