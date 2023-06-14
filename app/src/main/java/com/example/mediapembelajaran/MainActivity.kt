package com.example.mediapembelajaran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mediapembelajaran.core.helper.Connection
import com.example.mediapembelajaran.core.helper.SessionManager
import com.example.mediapembelajaran.core.service.AuthService
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
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var sessionManager: SessionManager
    lateinit var authService: AuthService
    lateinit var connection: Connection
    var username = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authService = AuthService.create(this)
        connection = Connection(this)

        username = intent.getStringExtra("username").toString()

        sessionManager = SessionManager(this)

        binding.btnBelajar.setOnClickListener {
            startActivity(Intent(this, PembelajaranActivity::class.java))
        }

        binding.btnKuis.setOnClickListener {
            startActivity(Intent(this, Quiz1Activity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            sessionManager.logoutUser()
            username = ""
        }

        if (username != ""){
            getProfile()
        }else{
            binding.tvBanner.text = "Hai, Selamat Datang \n\n$username"
            username = "Guest"
        }


    }

    fun getProfile(){
        if (connection.isConnectionInternet()){
            authService.getProfile(username).enqueue(object : Callback<ResponseBody>{
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful){

                        var response = response.body()?.string()
                        var jsonObject = JSONObject(response)
                        var status = jsonObject.getString("status")
                        var message = jsonObject.getString("message")
                        if(status == "success"){
                            var data = jsonObject.getJSONObject("data")
                            binding.tvBanner.text = "Hai, Selamat Datang \n\n${data.getString("nama")}"
                            Log.d("TAG", "onResponse: " + data)
                        }


                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d("TAG", "onFailure: " + t.message)
                }
            })
        }
    }
}