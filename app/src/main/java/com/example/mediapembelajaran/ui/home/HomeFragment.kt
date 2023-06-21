package com.example.mediapembelajaran.ui.home

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mediapembelajaran.core.helper.Connection
import com.example.mediapembelajaran.core.helper.SessionManager
import com.example.mediapembelajaran.core.service.AuthService
import com.example.mediapembelajaran.databinding.FragmentHomeBinding
import com.example.mediapembelajaran.menu.kuis.IntoQuizActivity
import com.example.mediapembelajaran.menu.pembelajaran.MateriActivity
import com.example.mediapembelajaran.menu.pembelajaran.VideoDetailActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var connection: Connection
    private lateinit var sessionManager: SessionManager
    private lateinit var authService: AuthService

    private var backPressedOnce = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        connection = Connection(this@HomeFragment.requireContext())
        sessionManager = SessionManager(this@HomeFragment.requireContext())
        authService = AuthService.create(this@HomeFragment.requireActivity())

        init()
        getData()
        initAdmob()

        return root
    }

    fun initAdmob(){
        MobileAds.initialize(requireContext()) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

        binding.adView.adListener = object: AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        }
    }

    fun init(){
        binding.btnBelajar.setOnClickListener {
            startActivity(Intent(context, MateriActivity::class.java))
        }

        binding.btnKuis.setOnClickListener {
            startActivity(Intent(context, IntoQuizActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            showDialogLogout()
        }
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

    private fun showDialogLogout(){
        val alertDialogBuilder = AlertDialog.Builder(this@HomeFragment.requireContext())
        alertDialogBuilder.setTitle("Logout Akun")
        alertDialogBuilder.setMessage("Apakah Anda yakin ingin keluar dari Akun?")
        alertDialogBuilder.setPositiveButton("Ya") { dialogInterface: DialogInterface, _: Int ->
            // Menutup aplikasi
            sessionManager.logoutUser()
            activity?.finish()
        }
        alertDialogBuilder.setNegativeButton("Tidak") { dialogInterface: DialogInterface, _: Int ->
            // Mengabaikan tombol "Back"
            dialogInterface.dismiss()
            backPressedOnce = false // Reset backPressedOnce saat tombol "Tidak" ditekan
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}