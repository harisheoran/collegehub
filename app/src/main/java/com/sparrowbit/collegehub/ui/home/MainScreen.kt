package com.sparrowbit.collegehub.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.sparrowbit.collegehub.CollegeHubApplication
import com.sparrowbit.collegehub.databinding.FragmentMainScreenBinding
import com.sparrowbit.collegehub.localdata.UserData
import com.sparrowbit.collegehub.model.Subject
import com.sparrowbit.collegehub.ui.onSubjectClickListener
import com.sparrowbit.collegehub.viewmodel.CollegeHubViewModel
import com.sparrowbit.collegehub.viewmodel.CollegeHubViewModelFactory
import com.sparrowbit.collegehub.viewmodel.FirestoreViewModel

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