package com.example.mediapembelajaran.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mediapembelajaran.databinding.LayoutPembelajaranBinding
import com.example.mediapembelajaran.model.PembelajaranModels

class PembelajaranAdapter(private var context: Context,private var pembelajaranModel:List<PembelajaranModels>) : RecyclerView.Adapter<PembelajaranAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: LayoutPembelajaranBinding) : RecyclerView.ViewHolder(binding.root)

    private var onClick: ((PembelajaranModels) -> Unit)? = null
    fun setOnClick(callback: (PembelajaranModels) -> Unit){
        this.onClick = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutPembelajaranBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pembelajaranModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(pembelajaranModel[position]){
                binding.tvTitle.text = this.title
                binding.tvDesc.text = this.description
                Glide.with(context).load(this.imageUrl).into(binding.ivThumbnail)
                binding.cvPembelajaran.setOnClickListener {
                    onClick?.invoke(pembelajaranModel[position])
                }
            }
        }
    }

}