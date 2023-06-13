package com.example.mediapembelajaran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediapembelajaran.databinding.ActivityMainBinding
import com.example.mediapembelajaran.menu.kuis.Quiz10Activity
import com.example.mediapembelajaran.menu.kuis.Quiz1Activity
import com.example.mediapembelajaran.menu.kuis.Quiz2Activity
import com.example.mediapembelajaran.menu.kuis.Quiz3Activity
import com.example.mediapembelajaran.menu.kuis.Quiz4Activity
import com.example.mediapembelajaran.menu.kuis.Quiz5Activity
import com.example.mediapembelajaran.menu.kuis.Quiz6Activity
import com.example.mediapembelajaran.menu.kuis.Quiz7Activity
import com.example.mediapembelajaran.menu.kuis.Quiz8Activity
import com.example.mediapembelajaran.menu.kuis.Quiz9Activity
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
            startActivity(Intent(this, Quiz1Activity::class.java))
        }


    }
}