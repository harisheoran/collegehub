package com.example.collegehub.ui

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.collegehub.databinding.FragmentNotesListScreenBinding
import com.example.collegehub.model.Chapter
import com.example.collegehub.viewmodel.FirestoreViewModel
import com.example.collegehub.viewmodel.NetworkStateViewModel

class NotesListScreen : Fragment() {
    private lateinit var networkViewModel: NetworkStateViewModel
    private var _binding: FragmentNotesListScreenBinding? = null
    private val binding get() = _binding!!
    private val firestoreViewModel: FirestoreViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesListScreenBinding.inflate(inflater, container, false)
        networkViewModel = ViewModelProvider(this).get(NetworkStateViewModel::class.java)
        networkViewModel.getNetworkState().observe(viewLifecycleOwner, {
            if (it) {
                firestoreViewModel.checkInternetConnection(true)
            } else {
                firestoreViewModel.checkInternetConnection(false)
                binding.chapterRecyclerView.visibility = View.INVISIBLE
            }
        })
        binding.lifecycleOwner = this
        binding.chapterRecyclerView.adapter =
            NotesAdapter(object : onChapterClickListener {
                override fun onChapterClick(chapter: Chapter) {
                    val link = chapter.link
                    val action = NotesListScreenDirections.actionNotesListScreenToNotesPdfViewScreen(link)
                    findNavController().navigate(action)
                }
            })
        binding.apply {
            viewModel = firestoreViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firestoreViewModel.tappedSubjectName.observe(viewLifecycleOwner) {
            firestoreViewModel.loadChapter(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
