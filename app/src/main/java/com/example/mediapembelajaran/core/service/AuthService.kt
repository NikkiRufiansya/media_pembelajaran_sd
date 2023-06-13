package com.example.mediapembelajaran.core.service

import android.app.Activity
import com.example.mediapembelajaran.core.retrofit.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface AuthService {
    @POST("login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<ResponseBody>

    companion object {
        fun create(activity: Activity): AuthService {
            return RetrofitClient.getClient(activity).create(AuthService::class.java)
        }

    }
}