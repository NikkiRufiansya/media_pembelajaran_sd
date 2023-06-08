package com.example.mediapembelajaran.menu.kuis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.databinding.ActivityQuiz1Binding

class Quiz1Activity : AppCompatActivity() {
    lateinit var binding: ActivityQuiz1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }

    }
}