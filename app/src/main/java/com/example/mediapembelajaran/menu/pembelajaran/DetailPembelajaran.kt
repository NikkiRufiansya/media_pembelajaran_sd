package com.example.mediapembelajaran.menu.pembelajaran

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.mediapembelajaran.databinding.ActivityDetailPembelajaranBinding

class DetailPembelajaran : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPembelajaranBinding

    private var title = ""
    private var desc = ""
    private var imgUrl = ""
    private var videoUrl = ""
    private var tema = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPembelajaranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        init()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@DetailPembelajaran, PembelajaranActivity::class.java)
        intent.putExtra("tema", tema)
        startActivity(intent)
    }

    private fun initData() {
        title = intent.getStringExtra("title").toString()
        desc = intent.getStringExtra("description").toString()
        imgUrl = intent.getStringExtra("imageUrl").toString()
        videoUrl = intent.getStringExtra("videoUrl").toString()
        tema = intent.getStringExtra("tema").toString()
    }

    private fun init() {
        binding.tvToolbar.text = "Video Pembelajaran"
        binding.tvTitle.text = title
        binding.tvDec.text = desc

        binding.btnBack.setOnClickListener {
            val intent = Intent(this@DetailPembelajaran, PembelajaranActivity::class.java)
            intent.putExtra("tema", tema)
            startActivity(intent)
        }

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.pluginState = WebSettings.PluginState.ON
        binding.webView.settings.loadWithOverviewMode = true
        binding.webView.settings.useWideViewPort = true

        binding.webView.webChromeClient = object : WebChromeClient() {
            private var mCustomView: View? = null
            private var mCustomViewCallback: CustomViewCallback? = null
            private var mOriginalOrientation: Int = 0

            override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
                if (mCustomView != null) {
                    callback?.onCustomViewHidden()
                    return
                }

                mCustomView = view
                mOriginalOrientation = requestedOrientation
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
                mCustomViewCallback = callback

                window.decorView.systemUiVisibility = (
                        View.SYSTEM_UI_FLAG_FULLSCREEN
                                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        )

                binding.webView.visibility = View.GONE
                setContentView(view)
            }

            override fun onHideCustomView() {
                mCustomView?.let {
                    binding.webView.visibility = View.VISIBLE
                    requestedOrientation = mOriginalOrientation
                    mCustomViewCallback?.onCustomViewHidden()

                    window.decorView.systemUiVisibility = (
                            View.SYSTEM_UI_FLAG_VISIBLE
                                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            )

                    setContentView(binding.root)
                    mCustomView = null
                }
            }
        }

        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }

        binding.webView.loadUrl(videoUrl)
    }
}
