package com.example.mediapembelajaran.core.service

import android.app.Activity
import com.example.mediapembelajaran.core.retrofit.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthService {
    @POST("login.php")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<ResponseBody>


    @POST("daftar.php")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    fun daftar(
        @Field("nis") nis: String,
        @Field("nama") nama: String,
        @Field("username") username:String,
        @Field("password") password: String,
        @Field("tempat_lahir") tempat_lahir: String,
        @Field("tanggal_lahir") tanggal_lahir: String,
        @Field("umur") umur: String
    ): Call<ResponseBody>

    @GET("getProfile.php?username=")
    fun getProfile(@Query("username") username: String) : Call<ResponseBody>
    companion object {
        fun create(activity: Activity): AuthService {
            return RetrofitClient.getClient(activity).create(AuthService::class.java)
        }

    }
}