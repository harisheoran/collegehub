package com.example.collegehub_beta.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.collegehub_beta.R
import com.example.collegehub_beta.databinding.FragmentChapterScreenBinding
import com.example.collegehub_beta.model.Chapter
import com.example.collegehub_beta.utils.onChapterClickListener


class ChapterScreen : Fragment() {

    private var _binding: FragmentChapterScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChapterScreenBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.chapterRecyclerView.adapter =
            ChapterAdapter(object : onChapterClickListener {
                override fun onChapterClick(chapter: Chapter) {
                    findNavController().navigate(R.id.action_chapterScreen_to_PDFViewScreen)
                }
            })

        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}