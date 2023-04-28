package com.example.collegehub_beta.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.collegehub_beta.R
import com.example.collegehub_beta.data.HomeData
import com.example.collegehub_beta.databinding.FragmentHomeScreenBinding


class HomeScreen : Fragment() {
    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        val homeItemsList = listOf<HomeData>(
            HomeData.Subject("Math", "math", R.drawable.homeinfo_img),
            HomeData.Subject("Math", "math", R.drawable.homeinfo_img),
            HomeData.Subject("Math", "math", R.drawable.homeinfo_img),
            HomeData.Subject("Math", "math", R.drawable.homeinfo_img),
            HomeData.HomeInfo("About App", "Update App")
        )
        val myAdapter = HomeScreenAdapter(homeItemsList)
        binding.homeRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.homeRecyclerView.adapter = myAdapter
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