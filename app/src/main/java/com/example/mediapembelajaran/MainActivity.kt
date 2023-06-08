package com.example.mediapembelajaran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediapembelajaran.databinding.ActivityMainBinding
import com.example.mediapembelajaran.menu.kuis.QuizActivity
import com.example.mediapembelajaran.menu.pembelajaran.PembelajaranActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBelajar.setOnClickListener {
            startActivity(Intent(this, PembelajaranActivity::class.java))
        }

        binding.btnKuis.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }
}