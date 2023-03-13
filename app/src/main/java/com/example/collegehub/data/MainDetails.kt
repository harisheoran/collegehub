package com.example.collegehub.data

import android.telecom.Call.Details
import androidx.annotation.StringRes
import com.example.collegehub.R
import com.example.collegehub.model.Chapter
import com.example.collegehub.model.MainDetail

class MainDetails {
    fun loadMainDetails(): List<MainDetail> = listOf(
        MainDetail(R.string.news),
        MainDetail(R.string.new_info),
        MainDetail(R.string.about_app),
        MainDetail(R.string.contact_us),
    )
}