package com.example.mediapembelajaran.core.helper

import android.content.SharedPreferences
import android.content.Context
import android.content.Intent
import com.example.mediapembelajaran.auth.LoginActivity


class SessionManager(context: Context) {
    private val PREF_NAME = "merchant app"
    private val _context = context
    private val IS_LOGIN = "IsLoggedIn"
    var sharedPreferences: SharedPreferences = _context.getSharedPreferences(PREF_NAME,0)
    var editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun setIsLogin(){
        editor.putBoolean(IS_LOGIN, true)
        editor.commit()
    }
    fun getIsLogin(): Boolean{
        return sharedPreferences.getBoolean(IS_LOGIN, false)
    }

    fun setUsername(username: String){
        editor.putString("username",username)
        editor.commit()
    }

    fun getUserName(): String{
        return  sharedPreferences.getString("username", "").toString()
    }

    fun setScore(score: Int){
        editor.putInt("score", score)
        editor.commit()
    }

    fun getScore(): Int{
        return sharedPreferences.getInt("score", 0)
    }

    fun logoutUser(){
        editor.clear()
        editor.commit()

        val i = Intent(_context, LoginActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        _context.startActivity(i)
    }



}