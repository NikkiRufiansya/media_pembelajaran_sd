package com.example.mediapembelajaran.auth

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mediapembelajaran.MainActivity
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.core.helper.Connection
import com.example.mediapembelajaran.core.helper.SessionManager
import com.example.mediapembelajaran.core.service.AuthService
import com.example.mediapembelajaran.databinding.ActivityDaftarBinding
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Calendar

class DaftarActivity : AppCompatActivity() {
    lateinit var binding: ActivityDaftarBinding
    lateinit var authService: AuthService
    lateinit var connection: Connection
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authService = AuthService.create(this)
        sessionManager = SessionManager(this)
        connection = Connection(this)

        binding.etTanggalLahir.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    var date =
                        (year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth.toString())
                    binding.etTanggalLahir.setText(date)
                },
                year,
                month,
                day
            )

            // at last we are calling show
            // to display our date picker dialog.
            datePickerDialog.show()

            binding.btnRegister.setOnClickListener {
                daftar()
            }

            binding.btnBack1.setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    fun daftar() {
        if (connection.isConnectionInternet()) {
            if (binding.etNis.text.isNotEmpty() &&
                binding.etNama.text.isNotEmpty() &&
                binding.etUsername.text.isNotEmpty() &&
                binding.etPassword.text.isNotEmpty() &&
                binding.etTempatLahir.text.isNotEmpty() &&
                binding.etTanggalLahir.text.isNotEmpty() &&
                binding.etUmur.text.isNotEmpty()){
                var daftar = authService.daftar(
                    binding.etNis.text.toString(),
                    binding.etNama.text.toString(),
                    binding.etUsername.text.toString(),
                    binding.etPassword.text.toString(),
                    binding.etTempatLahir.text.toString(),
                    binding.etTanggalLahir.text.toString(),
                    binding.etUmur.text.toString()
                )

                daftar.enqueue(object : Callback<ResponseBody>{
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
                                sessionManager.setIsLogin()
                                val intent = Intent(this@DaftarActivity, MainActivity::class.java)
                                intent.putExtra("username", binding.etUsername.text.toString())
                                sessionManager.setUsername(binding.etUsername.text.toString())
                                startActivity(intent)
                                Toast.makeText(this@DaftarActivity, message.toString(), Toast.LENGTH_SHORT).show()
                                finish()
                            }else{
                                Toast.makeText(this@DaftarActivity, message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Toast.makeText(this@DaftarActivity, "Pastikan Koneksi Internet Anda Nyala", Toast.LENGTH_SHORT).show()

                    }
                })
            }else{
                Toast.makeText(this@DaftarActivity,"Data Kurang Lengkap", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Pastikan Koneksi Internet Anda Nyala", Toast.LENGTH_SHORT).show()
        }
    }
}