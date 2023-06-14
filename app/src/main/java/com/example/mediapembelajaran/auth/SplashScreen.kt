package com.example.mediapembelajaran.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.mediapembelajaran.MainActivity
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.core.helper.SessionManager

class SplashScreen : AppCompatActivity() {
    lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        sessionManager = SessionManager(this)

        Handler().postDelayed({
            if(sessionManager.getIsLogin()){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        },3000)


    }
}