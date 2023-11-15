package com.sparrowbit.collegehub.ui.offlineui

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sparrowbit.collegehub.databinding.FragmentOfflineBinding
import java.io.File


class Offline : Fragment() {
    private var _binding: FragmentOfflineBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentOfflineBinding.inflate(inflater, container, false)
        val myAdapter = OfflineAdapter(requireContext(), getPdfFiles())
        binding.offlineRecyclerView.adapter = myAdapter
        return binding.root
    }




    private fun getPdfFiles(): List<File> {
        val pdfDir = File(requireContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "pdfs")
        return pdfDir.listFiles { file ->
            file.extension == "pdf"
        }.toList()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}