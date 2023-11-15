package com.sparrowbit.collegehub.ui.profileui

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sparrowbit.collegehub.CollegeHubApplication
import com.sparrowbit.collegehub.data.DepartmentAndSemesterNameList
import com.sparrowbit.collegehub.databinding.FragmentProfileEditBinding
import com.sparrowbit.collegehub.localdata.UserData

import com.sparrowbit.collegehub.viewmodel.CollegeHubViewModel
import com.sparrowbit.collegehub.viewmodel.CollegeHubViewModelFactory


class ProfileEdit : Fragment() {
    private val args: ProfileEditArgs by navArgs()

    private var _binding: FragmentProfileEditBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CollegeHubViewModel by activityViewModels {
        CollegeHubViewModelFactory(
            (activity?.application as CollegeHubApplication).database.userDataDao()
        )
    }

    private lateinit var userData: UserData



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProfileEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val departmentList = DepartmentAndSemesterNameList.departmentList()
        val semesterList = DepartmentAndSemesterNameList.semesterList()

        val departmentAdapter =
            ArrayAdapter(requireContext(), R.layout.simple_spinner_dropdown_item, departmentList.map {
                it.name
            })

        val semesterAdapter =
            ArrayAdapter(requireContext(), R.layout.simple_spinner_dropdown_item, semesterList.map {
                it.name
            })

        val departmentSpinner = view.findViewById<Spinner>(com.sparrowbit.collegehub.R.id.departmentSelect)
        val semesterSpinner = view.findViewById<Spinner>(com.sparrowbit.collegehub.R.id.semesterSelect)

        departmentSpinner.adapter = departmentAdapter
        semesterSpinner.adapter = semesterAdapter

        //listener for user's interaction
        departmentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedDepartment = departmentList[position]
                viewModel.setDepartment(selectedDepartment)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        semesterSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedSemester = semesterList[position]
                viewModel.setSemester(selectedSemester)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        binding.editSave.setOnClickListener {
            updateUserData()
        }

    }


    private fun updateUserData() {
        val userName = binding.userNameField.text.toString() ?: "No Name"
        viewModel.setUserName(userName)
        viewModel.updateUserData(args.id)
        val action = ProfileEditDirections.actionProfileEditToMainProfile()
        this.findNavController().navigate(action)
    }


}