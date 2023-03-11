package com.example.collegehub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.collegehub.R
import com.example.collegehub.databinding.FragmentMainScreenBinding
import com.example.collegehub.databinding.FragmentNotesListScreenBinding
import com.example.collegehub.model.Chapter
import com.example.collegehub.model.HubViewModel

class NotesListScreen : Fragment() {
    private var _binding: FragmentNotesListScreenBinding? = null
    private val binding get() = _binding!!
    private val myViewModel: HubViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentNotesListScreenBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.chapterRecyclerView.adapter = NotesAdapter(ClickBehviourChapters { chapter: Chapter ->
            findNavController().navigate(R.id.action_notesListScreen_to_notes_Pdf_view_screen)
        })
        binding.viewModel = myViewModel
        return binding.root
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}