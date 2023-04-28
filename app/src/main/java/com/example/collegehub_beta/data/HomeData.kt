package com.example.collegehub_beta.data

import androidx.annotation.DrawableRes
import com.example.collegehub_beta.model.Subject

sealed class HomeData {
    data class Header(val title: String) : HomeData()
    data class Subject(val name: String, val id: String, @DrawableRes val img: Int) : HomeData()
    data class HomeInfo(val title: String, val description: String) : HomeData()
    data class advertisement(val title: String, val description: String) : HomeData()
}

