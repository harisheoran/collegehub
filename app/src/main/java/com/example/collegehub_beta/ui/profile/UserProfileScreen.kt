package com.example.collegehub_beta.ui.profile

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.collegehub_beta.databinding.FragmentUserProfileScreenBinding


class UserProfileScreen : Fragment() {
    private var _binding: FragmentUserProfileScreenBinding? = null
    private val binding get() = _binding!!

    override fun onPrepareOptionsMenu(menu: Menu) {
        val item = menu.findItem(com.example.collegehub_beta.R.id.userProfileScreen)
        item?.setVisible(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserProfileScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}