package com.example.mediapembelajaran.ui.nilai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.adapter.NilaiAdapter
import com.example.mediapembelajaran.core.db.SqliteHelper
import com.example.mediapembelajaran.databinding.FragmentNilaiBinding

class NilaiFragment : Fragment() {
    private var _binding: FragmentNilaiBinding? = null
    private val binding get() = _binding!!
    private lateinit var sqliteHelper: SqliteHelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNilaiBinding.inflate(inflater, container, false)
        val root: View = binding.root

        sqliteHelper = SqliteHelper(this@NilaiFragment.requireContext())
        getData()
        return root
    }


    fun getData(){
        var nilaiList = sqliteHelper.getAllNilai()

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        binding.rvNilai.layoutManager = layoutManager
        val nilaiAdapter : NilaiAdapter = NilaiAdapter(requireContext(), nilaiList)
        binding.rvNilai.adapter = nilaiAdapter
        nilaiAdapter.notifyDataSetChanged()
    }

}