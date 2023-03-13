package com.example.collegehub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.collegehub.R
import com.example.collegehub.data.Subjects
import com.example.collegehub.databinding.FragmentMainScreenBinding
import com.example.collegehub.model.HubViewModel
import com.example.collegehub.model.Subject

class MainScreen : Fragment() {
    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() =  _binding!!
    private val viewModel: HubViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.subjectRecyclerView.adapter = SubjectsAdapter(ClickBehaviour {subject: Subject ->
            findNavController().navigate(R.id.action_mainScreen_to_notesListScreen)
        })
        binding.detailsRecycletrView.adapter = MainDetailsAdapter()
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}