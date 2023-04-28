package com.example.collegehub_beta.model

import androidx.annotation.DrawableRes
import com.example.collegehub_beta.data.HomeData

data class Subject(
    val name: String,
    val id: String,
    @DrawableRes val img: Int
)
