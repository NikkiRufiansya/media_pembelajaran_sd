package com.example.mediapembelajaran.menu.kuis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.databinding.ActivityIntoQuizBinding

class IntoQuizActivity : AppCompatActivity() {
    lateinit var binding : ActivityIntoQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntoQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart?.setOnClickListener {
            startActivity(Intent(this@IntoQuizActivity, Quiz1Activity::class.java))
        }

    }
}