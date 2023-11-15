package com.sparrowbit.collegehub.ui.offlineui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sparrowbit.collegehub.databinding.NotesCardViewBinding
import java.io.File

class OfflineAdapter(private val context: Context, val offlineDataList: List<File>) :
    RecyclerView.Adapter<OfflineAdapter.OfflineViewHolder>() {

    inner class OfflineViewHolder(var binding: NotesCardViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myPdfFile: File) {
            binding.textView2.text = myPdfFile.name
            binding.root.setOnClickListener {
                Toast.makeText(context, "PDF HELlO", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfflineViewHolder {
        val view = OfflineViewHolder(NotesCardViewBinding.inflate(LayoutInflater.from(parent.context)))
        return view
    }

    override fun getItemCount(): Int {
        return offlineDataList.size
    }

    override fun onBindViewHolder(holder: OfflineViewHolder, position: Int) {
        val pdfFile = offlineDataList[position]
        holder.bind(pdfFile)
    }
}