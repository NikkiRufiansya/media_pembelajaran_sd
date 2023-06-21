package com.example.mediapembelajaran.menu.pembelajaran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediapembelajaran.MainActivity
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.databinding.ActivityMateriBinding

class MateriActivity : AppCompatActivity() {
    lateinit var binding: ActivityMateriBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMateriBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init() {
        binding.btnTema1.setOnClickListener {
            val intentTema1 = Intent(this, PembelajaranActivity::class.java)
            intentTema1.putExtra("tema", "tema1")
            startActivity(intentTema1)
        }

        binding.btnTema2.setOnClickListener {
            val intentTema2 = Intent(this, PembelajaranActivity::class.java)
            intentTema2.putExtra("tema", "tema2")
            startActivity(intentTema2)
        }

        binding.btnTema3.setOnClickListener {
            val intentTema3 = Intent(this, PembelajaranActivity::class.java)
            intentTema3.putExtra("tema", "tema3")
            startActivity(intentTema3)
        }

        binding.btnTema4.setOnClickListener {
            val intentTema4 = Intent(this, PembelajaranActivity::class.java)
            intentTema4.putExtra("tema", "tema4")
            startActivity(intentTema4)
        }

        binding.btnTema5.setOnClickListener {
            val intentTema5 = Intent(this, PembelajaranActivity::class.java)
            intentTema5.putExtra("tema", "tema5")
            startActivity(intentTema5)
        }

        binding.btnBack.setOnClickListener {
            super.onBackPressed()
            finish()
        }


    }
}