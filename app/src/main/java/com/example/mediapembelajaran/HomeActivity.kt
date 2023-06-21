package com.example.mediapembelajaran

import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.mediapembelajaran.core.helper.Connection
import com.example.mediapembelajaran.core.helper.SessionManager
import com.example.mediapembelajaran.core.service.AuthService
import com.example.mediapembelajaran.databinding.ActivityHomeBinding
import com.example.mediapembelajaran.databinding.NavHeaderHomeBinding
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    private lateinit var sessionManager: SessionManager
    private lateinit var connection: Connection
    private lateinit var authService: AuthService
    private var backPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarHome.toolbar)

        sessionManager = SessionManager(this)
        connection = Connection(this)
        authService = AuthService.create(this)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


        var headerBinding = navView.getHeaderView(0)
        var tvNama = headerBinding.findViewById<TextView>(R.id.tv_name)
        var tvKelas = headerBinding.findViewById<TextView>(R.id.tv_kelas)


        if (connection.isConnectionInternet()){
            var user = authService.getProfile(sessionManager.getUserName())
            user.enqueue(object : Callback<ResponseBody>{
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                   if(response.isSuccessful){
                       var response = response.body()?.string()
                       var jsonObject = JSONObject(response)
                       var status = jsonObject.getString("status")
                       var message = jsonObject.getString("message")
                       if(status == "success"){
                           var data = jsonObject.getJSONObject("data")
                           tvNama.text = data.getString("nama")
                           tvKelas.text = "Kelas : " + data.getString("kelas")
                       }
                   }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d("TAG", "onFailure: " + t.message)
                }
            })
        }




        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_profile, R.id.nav_nilai
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (backPressedOnce) {
            super.onBackPressed()
            return
        }

        this.backPressedOnce = true
        showExitDialog()

        // Reset backPressedOnce setelah 2 detik
        Handler().postDelayed({
            backPressedOnce = false
        }, 2000)
    }
    private fun showExitDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Keluar dari Aplikasi")
        alertDialogBuilder.setMessage("Apakah Anda yakin ingin keluar?")
        alertDialogBuilder.setPositiveButton("Ya") { dialogInterface: DialogInterface, _: Int ->
            // Menutup aplikasi
            finish()
        }
        alertDialogBuilder.setNegativeButton("Tidak") { dialogInterface: DialogInterface, _: Int ->
            // Mengabaikan tombol "Back"
            dialogInterface.dismiss()
            backPressedOnce = false // Reset backPressedOnce saat tombol "Tidak" ditekan
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

}