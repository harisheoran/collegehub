package com.example.collegehub.ui.profileui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.collegehub.CollegeHubApplication
import com.example.collegehub.databinding.FragmentMainProfileBinding
import com.example.collegehub.localdata.UserData
import com.example.collegehub.viewmodel.CollegeHubViewModel
import com.example.collegehub.viewmodel.CollegeHubViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainProfile : Fragment() {
    private var _binding: FragmentMainProfileBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentMainProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.readUserData().observe(this.viewLifecycleOwner) {
            userData = it
            val id = it.id
            binding.profileEdit.setOnClickListener {
                val action = MainProfileDirections.actionMainProfileToProfileEdit2(id)
                this.findNavController().navigate(action)
            }
            bind(it)
        }

        additionalInfoIntents()

    }

    private fun bind(userData: UserData) {
        binding.userName.text = userData.userName
        binding.userDepartment.text = userData.department
        binding.userSemester.text = userData.semester
    }

    private fun additionalInfoIntents() {
        // Contact Us
        binding.contact.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://collegehub.pages.dev/"))
            startActivity(intent)
        }

        // Help Centre
        binding.helpCentre.setOnClickListener {
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse(""))
            startActivity(intent)
        }


        // About Us
        binding.aboutUs.setOnClickListener {
            binding.privacyPolicy.setOnClickListener {
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(""))
                startActivity(intent)
            }
        }

        // Terms & Privacy Policy
        binding.privacyPolicy.setOnClickListener {
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://collegehub.pages.dev/privacypolicy"))
            startActivity(intent)
        }
    }

}