package com.example.collegehub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collegehub.R
import com.example.collegehub.data.Subjects
import com.example.collegehub.databinding.FragmentMainScreenBinding

class MainScreen : Fragment() {
    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    // Inflating the view
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        val fragmentView = binding.root
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.mainRecyclerView
        recyclerView.adapter = MainAdapter(this.requireContext(), Subjects().subjectsList())
        recyclerView.layoutManager = GridLayoutManager(this.requireContext(), 2)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}