package com.example.collegehub

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.collegehub.model.Chapter
import com.example.collegehub.model.Subject
import com.example.collegehub.ui.NotesAdapter
import com.example.collegehub.ui.SubjectsAdapter
import com.example.collegehub.viewmodel.FireStoreStatus

@BindingAdapter("setData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Subject>?) {
    val adapter = recyclerView.adapter as SubjectsAdapter
    adapter.submitList(data)
}

@BindingAdapter("setChapter")
fun bindChapterRecyclerView(recyclerView: RecyclerView, data: List<Chapter>?) {
    val adapter = recyclerView.adapter as NotesAdapter
    adapter.submitList(data)
}

@BindingAdapter("setFirestoreStatus")
fun setFireStoreStatus(lottieAnim: LottieAnimationView, status: FireStoreStatus?) {
    when (status) {
        FireStoreStatus.LOADING -> {
            lottieAnim.visibility = View.VISIBLE
            lottieAnim.imageAssetsFolder = "assets"
            lottieAnim.setAnimation("loading.json")
        }
        FireStoreStatus.SUCCESS -> {
            lottieAnim.visibility = View.GONE
        }
        FireStoreStatus.ERROR -> {
            lottieAnim.visibility = View.VISIBLE
            lottieAnim.imageAssetsFolder = "assets"
            lottieAnim.setAnimation("not_found .json")
            lottieAnim.loop(true)
            lottieAnim.playAnimation()
        }
        FireStoreStatus.NO_INTERNET -> {
            lottieAnim.visibility = View.VISIBLE
            lottieAnim.imageAssetsFolder = "assets"
            lottieAnim.setAnimation("no_internet.json")
            lottieAnim.loop(true)
            lottieAnim.playAnimation()
        }
        else -> {

        }
    }
}