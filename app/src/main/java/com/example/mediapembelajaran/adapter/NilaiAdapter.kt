package com.example.mediapembelajaran.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mediapembelajaran.databinding.LayoutNilaiBinding
import com.example.mediapembelajaran.model.NilaiModels

class NilaiAdapter(private var context: Context, private var nilaiModels: List<NilaiModels>) : RecyclerView.Adapter<NilaiAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: LayoutNilaiBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutNilaiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return nilaiModels.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(nilaiModels[position]){
                binding.tvNilai.text = "Score Nilai : " + this.nilai+"0"
            }
        }
    }


}