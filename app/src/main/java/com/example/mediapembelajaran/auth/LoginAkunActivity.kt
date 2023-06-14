package com.example.mediapembelajaran.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mediapembelajaran.MainActivity
import com.example.mediapembelajaran.core.helper.Connection
import com.example.mediapembelajaran.core.helper.SessionManager
import com.example.mediapembelajaran.core.service.AuthService
import com.example.mediapembelajaran.databinding.ActivityLoginAkunBinding
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginAkunActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginAkunBinding
    lateinit var connection : Connection
    lateinit var sessionManager: SessionManager
    lateinit var authService: AuthService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginAkunBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)
        authService = AuthService.create(this)
        connection = Connection(this)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.btnLogin.setOnClickListener {
            login()
        }

    }

    fun login(){
        if (connection.isConnectionInternet()){
            if(binding.etUsername.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()){
                var auth = authService.login(binding.etUsername.text.toString(), binding.etPassword.text.toString())
                auth.enqueue(object : Callback<ResponseBody>{
                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        if(response.isSuccessful){
                            var response = response.body()?.string()
                            var jsonObject = JSONObject(response)
                            var status = jsonObject.getString("status")
                            var message = jsonObject.getString("message")
                            if (status == "success"){
                                sessionManager.setIsLogin()
                                val intent = Intent(this@LoginAkunActivity, MainActivity::class.java)
                                intent.putExtra("username", binding.etUsername.text.toString())
                                startActivity(intent)
                                Toast.makeText(this@LoginAkunActivity, message, Toast.LENGTH_SHORT).show()
                                finish()
                            }else{
                                Toast.makeText(this@LoginAkunActivity, message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Log.d("TAG", "onFailure: " + t.message)
                    }
                })
            }else{
                Toast.makeText(this@LoginAkunActivity, "Username & Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this@LoginAkunActivity, "Pastikan Koneksi Internet Anda Nyala", Toast.LENGTH_SHORT).show()

        }




    }


}