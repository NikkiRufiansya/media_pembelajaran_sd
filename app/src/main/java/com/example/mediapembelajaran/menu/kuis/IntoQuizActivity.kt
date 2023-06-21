package com.example.mediapembelajaran.menu.kuis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mediapembelajaran.HomeActivity
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.databinding.ActivityIntoQuizBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class IntoQuizActivity : AppCompatActivity() {
    lateinit var binding : ActivityIntoQuizBinding
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntoQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadIklan()
        showIklan()
        binding.btnStart?.setOnClickListener {
            showIklan()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this@IntoQuizActivity, HomeActivity::class.java))
    }

    fun showIklan(){
        if(mInterstitialAd != null){
            mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
                override fun onAdClicked() {
                    // Called when a click is recorded for an ad.
                    Log.d("TAG", "Ad was clicked.")
                }

                override fun onAdDismissedFullScreenContent() {
                    // Called when ad is dismissed.
                    Log.d("TAG", "Ad dismissed fullscreen content.")
                    startActivity(Intent(this@IntoQuizActivity, Quiz1Activity::class.java))


                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    // Called when ad fails to show.
                    Log.e("TAG", "Ad failed to show fullscreen content.")

                }

                override fun onAdImpression() {
                    // Called when an impression is recorded for an ad.
                    Log.d("TAG", "Ad recorded an impression.")
                }

                override fun onAdShowedFullScreenContent() {
                    // Called when ad is shown.
                    Log.d("TAG", "Ad showed fullscreen content.")
                }
            }

            mInterstitialAd?.show(this@IntoQuizActivity)
        }else{
            //startActivity(Intent(this@IntoQuizActivity, Quiz1Activity::class.java))
            
        }
    }
    fun loadIklan(){
        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d("TAG", "onAdFailedToLoad: " + adError)
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
            }
        })
    }




}