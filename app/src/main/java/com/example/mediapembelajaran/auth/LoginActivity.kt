package com.example.mediapembelajaran.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mediapembelajaran.MainActivity
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.core.helper.SessionManager
import com.example.mediapembelajaran.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var sessionManeger: SessionManager
    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sessionManeger = SessionManager(this)
        binding.btnWithoutLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            sessionManeger.setIsLogin()
            finish()
        }

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginAkunActivity::class.java))
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, DaftarActivity::class.java))
        }



    }
}