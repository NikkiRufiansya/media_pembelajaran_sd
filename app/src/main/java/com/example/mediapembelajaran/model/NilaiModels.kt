package com.example.mediapembelajaran.model

import java.util.Random

class NilaiModels (var id: Int= getAutoId(),  var nilai : String = ""){
    companion object{
        fun getAutoId(): Int{
            val random = Random()
            return random.nextInt(100);
        }
    }
}