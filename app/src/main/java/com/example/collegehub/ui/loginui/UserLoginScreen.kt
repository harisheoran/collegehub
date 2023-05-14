package com.example.collegehub.ui.loginui

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.collegehub.CollegeHubApplication
import com.example.collegehub.HomeActivity
import com.example.collegehub.R
import com.example.collegehub.data.DepartmentAndSemesterNameList
import com.example.collegehub.databinding.FragmentUserLoginScreenBinding
import com.example.collegehub.localdata.UserData
import com.example.collegehub.viewmodel.CollegeHubViewModel
import com.example.collegehub.viewmodel.CollegeHubViewModelFactory

class UserLoginScreen : Fragment() {
    private var _binding: FragmentUserLoginScreenBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CollegeHubViewModel by activityViewModels {
        CollegeHubViewModelFactory(
            (activity?.application as CollegeHubApplication).database.userDataDao()
        )
    }
    lateinit var userData: UserData


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserLoginScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val departmentList = DepartmentAndSemesterNameList.departmentList()
        val semesterList = DepartmentAndSemesterNameList.semesterList()

        val departmentAdapter =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                departmentList.map {
                    it.name
                })


        val semesterAdapter =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                semesterList.map {
                    it.name
                })


        val departmentSpinner = view.findViewById<Spinner>(R.id.departmentSelect)
        val semesterSpinner = view.findViewById<Spinner>(R.id.semesterSelect)

        departmentSpinner.adapter = departmentAdapter
      //  val deptTextView = departmentSpinner.selectedView as TextView
    //    deptTextView.setTextColor(resources.getColor(R.color.md_theme_dark_shadow))
        semesterSpinner.adapter = semesterAdapter


        //listener for user's interaction
        departmentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedDepartment = departmentList[position]
                viewModel.setDepartment(selectedDepartment)

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        semesterSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedSemester = semesterList[position]
                viewModel.setSemester(selectedSemester)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding.login.setOnClickListener {
            addUserData()
        }
    }


    private fun addUserData() {
        val userName = binding.userNameField.text.toString() ?: "xyz"
        viewModel.setUserName(userName)
        viewModel.saveSelectedUserData()
        val sharedPref = activity?.getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()
        editor?.putBoolean("isUserLoggedIn", true)
        editor?.apply()
        val intent = Intent(requireContext(), HomeActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}