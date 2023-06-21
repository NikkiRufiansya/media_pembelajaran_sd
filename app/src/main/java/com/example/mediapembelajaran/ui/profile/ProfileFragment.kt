package com.example.mediapembelajaran.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.core.helper.Connection
import com.example.mediapembelajaran.core.helper.SessionManager
import com.example.mediapembelajaran.core.service.AuthService
import com.example.mediapembelajaran.databinding.FragmentProfileBinding
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var connection: Connection
    private lateinit var sessionManager: SessionManager
    private lateinit var authService: AuthService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container,false)
        val root: View = binding.root

        connection = Connection(this@ProfileFragment.requireContext())
        sessionManager = SessionManager(this@ProfileFragment.requireContext())
        authService = AuthService.create(this@ProfileFragment.requireActivity())


        getData()

        return root
    }

    fun getData(){
        if (connection.isConnectionInternet()){
            var user = authService.getProfile(sessionManager.getUserName())
            user.enqueue(object : Callback<ResponseBody>{
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
                            binding.tvNama.text = data.getString("nama")
                            binding.tvKelas.text = data.getString("kelas")
                            binding.tvUsername.text = data.getString("username")
                            binding.tvTempatLahir.text = data.getString("tempat_lahir")
                            binding.tvTanggalLahir.text =  data.getString("tanggal_lahir")
                            binding.tvUmur.text = data.getString("umur")
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