package com.example.mediapembelajaran.menu.pembelajaran

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings.PluginState
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.mediapembelajaran.databinding.ActivityDetailPembelajaranBinding


class DetailPembelajaran : AppCompatActivity() {
    lateinit var binding: ActivityDetailPembelajaranBinding

    var title = ""
    var desc = ""
    var imgUrl = ""
    var videoUrl = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPembelajaranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        init()
    }


    fun initData(){
        title = intent.getStringExtra("title").toString()
        desc = intent.getStringExtra("description").toString()
        imgUrl = intent.getStringExtra("imageUrl").toString()
        videoUrl = intent.getStringExtra("videoUrl").toString()
    }

    fun init(){
        binding.tvToolbar.text = title
        binding.tvDec.text = desc

        binding.webView.getSettings().setJavaScriptEnabled(true)
        binding.webView.getSettings().setPluginState(PluginState.ON)
        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url.toString())
                return true
            }
        }
        binding.webView.loadUrl(videoUrl)
        //binding.webView.loadUrl(videoUrl)
        binding.webView.setWebChromeClient(WebChromeClient())


    }



}