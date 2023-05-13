package com.example.collegehub.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.collegehub.CollegeHubApplication
import com.example.collegehub.databinding.FragmentMainScreenBinding
import com.example.collegehub.localdata.UserData
import com.example.collegehub.model.Subject
import com.example.collegehub.viewmodel.CollegeHubViewModel
import com.example.collegehub.viewmodel.CollegeHubViewModelFactory
import com.example.collegehub.viewmodel.FirestoreViewModel

private val TAG = "SUBJECT LIST LOADING"

class MainScreen : Fragment() {
    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!
    private val firestoreViewModel: FirestoreViewModel by activityViewModels()
    private val myViewModel: CollegeHubViewModel by activityViewModels {
        CollegeHubViewModelFactory(
            (activity?.application as CollegeHubApplication).database.userDataDao()
        )
    }
    lateinit var userData: UserData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        val myAdapter = SubjectsAdapter(object : onSubjectClickListener {
            override fun onSubjectClick(subject: Subject) {
                val name = subject.name
                val id = subject.id
                firestoreViewModel.setTappedSubjectName(id)
                val action = MainScreenDirections.actionMainScreenToNotesListScreen(name)
                findNavController().navigate(action)
            }
        })
        binding.subjectRecyclerView.adapter = myAdapter
        myViewModel.userLoggedInData.observe(this.viewLifecycleOwner) {
            it.let {
                userData = it
                myViewModel.loadSubjects(userData)
            }
        }
        myViewModel.subjectList.observe(this.viewLifecycleOwner) {
            it.let {
                myAdapter.submitList(it)
            }
        }
        binding.viewmodel = myViewModel
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}