package com.example.mediapembelajaran.menu.pembelajaran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.adapter.PembelajaranAdapter
import com.example.mediapembelajaran.databinding.ActivityPembelajaranBinding
import com.example.mediapembelajaran.model.PembelajaranModels

class PembelajaranActivity : AppCompatActivity() {
    lateinit var binding: ActivityPembelajaranBinding
    lateinit var adapter: PembelajaranAdapter
    var pembelajaranList: ArrayList<PembelajaranModels> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPembelajaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
    }

    private fun initData(){
        pembelajaranList.add(
            PembelajaranModels(
                title = "Belajar Berhitung",
                description = "Video edukasi untuk anak-anak yang ingin belajar berhitung atau belajar mengenal angka sambil bernyanyi dengan animasi yang menarik sehingga anak-anak akan lebih tertarik dan senang untuk belajar berhitung atau belajar mengenal angka, diiringi dengan musik dan lagu ceria yang mudah diingat oleh anak-anak. Untuk para orang tua yang ingin anaknya bisa belajar berhitung, silakan ditonton video ini, semoga anak-anak suka dengan video ini. Jangan lupa di like, share dan ditonton video-video lainnya di channel Hore Kids ini. Terima kasih",
                imageUrl = "https://img.youtube.com/vi/KxKuWkUHSck/0.jpg",
                videoUrl = "https://www.youtube.com/embed/KxKuWkUHSck?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Belajar Berhitung",
                description = "Video edukasi untuk anak-anak yang ingin belajar berhitung atau belajar mengenal angka sambil bernyanyi dengan animasi yang menarik sehingga anak-anak akan lebih tertarik dan senang untuk belajar berhitung atau belajar mengenal angka, diiringi dengan musik dan lagu ceria yang mudah diingat oleh anak-anak. Untuk para orang tua yang ingin anaknya bisa belajar berhitung, silakan ditonton video ini, semoga anak-anak suka dengan video ini. Jangan lupa di like, share dan ditonton video-video lainnya di channel Hore Kids ini. Terima kasih",
                imageUrl = "https://img.youtube.com/vi/KxKuWkUHSck/0.jpg",
                videoUrl = "https://www.youtube.com/embed/KxKuWkUHSck?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Belajar Berhitung",
                description = "Video edukasi untuk anak-anak yang ingin belajar berhitung atau belajar mengenal angka sambil bernyanyi dengan animasi yang menarik sehingga anak-anak akan lebih tertarik dan senang untuk belajar berhitung atau belajar mengenal angka, diiringi dengan musik dan lagu ceria yang mudah diingat oleh anak-anak. Untuk para orang tua yang ingin anaknya bisa belajar berhitung, silakan ditonton video ini, semoga anak-anak suka dengan video ini. Jangan lupa di like, share dan ditonton video-video lainnya di channel Hore Kids ini. Terima kasih",
                imageUrl = "https://img.youtube.com/vi/KxKuWkUHSck/0.jpg",
                videoUrl = "https://www.youtube.com/embed/KxKuWkUHSck?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Belajar Berhitung",
                description = "Video edukasi untuk anak-anak yang ingin belajar berhitung atau belajar mengenal angka sambil bernyanyi dengan animasi yang menarik sehingga anak-anak akan lebih tertarik dan senang untuk belajar berhitung atau belajar mengenal angka, diiringi dengan musik dan lagu ceria yang mudah diingat oleh anak-anak. Untuk para orang tua yang ingin anaknya bisa belajar berhitung, silakan ditonton video ini, semoga anak-anak suka dengan video ini. Jangan lupa di like, share dan ditonton video-video lainnya di channel Hore Kids ini. Terima kasih",
                imageUrl = "https://img.youtube.com/vi/KxKuWkUHSck/0.jpg",
                videoUrl = "https://www.youtube.com/embed/KxKuWkUHSck?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Belajar Berhitung",
                description = "Video edukasi untuk anak-anak yang ingin belajar berhitung atau belajar mengenal angka sambil bernyanyi dengan animasi yang menarik sehingga anak-anak akan lebih tertarik dan senang untuk belajar berhitung atau belajar mengenal angka, diiringi dengan musik dan lagu ceria yang mudah diingat oleh anak-anak. Untuk para orang tua yang ingin anaknya bisa belajar berhitung, silakan ditonton video ini, semoga anak-anak suka dengan video ini. Jangan lupa di like, share dan ditonton video-video lainnya di channel Hore Kids ini. Terima kasih",
                imageUrl = "https://img.youtube.com/vi/KxKuWkUHSck/0.jpg",
                videoUrl = "https://www.youtube.com/embed/KxKuWkUHSck?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Belajar Berhitung",
                description = "Video edukasi untuk anak-anak yang ingin belajar berhitung atau belajar mengenal angka sambil bernyanyi dengan animasi yang menarik sehingga anak-anak akan lebih tertarik dan senang untuk belajar berhitung atau belajar mengenal angka, diiringi dengan musik dan lagu ceria yang mudah diingat oleh anak-anak. Untuk para orang tua yang ingin anaknya bisa belajar berhitung, silakan ditonton video ini, semoga anak-anak suka dengan video ini. Jangan lupa di like, share dan ditonton video-video lainnya di channel Hore Kids ini. Terima kasih",
                imageUrl = "https://img.youtube.com/vi/KxKuWkUHSck/0.jpg",
                videoUrl = "https://www.youtube.com/embed/KxKuWkUHSck?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Belajar Berhitung",
                description = "Video edukasi untuk anak-anak yang ingin belajar berhitung atau belajar mengenal angka sambil bernyanyi dengan animasi yang menarik sehingga anak-anak akan lebih tertarik dan senang untuk belajar berhitung atau belajar mengenal angka, diiringi dengan musik dan lagu ceria yang mudah diingat oleh anak-anak. Untuk para orang tua yang ingin anaknya bisa belajar berhitung, silakan ditonton video ini, semoga anak-anak suka dengan video ini. Jangan lupa di like, share dan ditonton video-video lainnya di channel Hore Kids ini. Terima kasih",
                imageUrl = "https://img.youtube.com/vi/KxKuWkUHSck/0.jpg",
                videoUrl = "https://www.youtube.com/embed/KxKuWkUHSck?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Belajar Berhitung",
                description = "Video edukasi untuk anak-anak yang ingin belajar berhitung atau belajar mengenal angka sambil bernyanyi dengan animasi yang menarik sehingga anak-anak akan lebih tertarik dan senang untuk belajar berhitung atau belajar mengenal angka, diiringi dengan musik dan lagu ceria yang mudah diingat oleh anak-anak. Untuk para orang tua yang ingin anaknya bisa belajar berhitung, silakan ditonton video ini, semoga anak-anak suka dengan video ini. Jangan lupa di like, share dan ditonton video-video lainnya di channel Hore Kids ini. Terima kasih",
                imageUrl = "https://img.youtube.com/vi/KxKuWkUHSck/0.jpg",
                videoUrl = "https://www.youtube.com/embed/KxKuWkUHSck?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Belajar Berhitung",
                description = "Video edukasi untuk anak-anak yang ingin belajar berhitung atau belajar mengenal angka sambil bernyanyi dengan animasi yang menarik sehingga anak-anak akan lebih tertarik dan senang untuk belajar berhitung atau belajar mengenal angka, diiringi dengan musik dan lagu ceria yang mudah diingat oleh anak-anak. Untuk para orang tua yang ingin anaknya bisa belajar berhitung, silakan ditonton video ini, semoga anak-anak suka dengan video ini. Jangan lupa di like, share dan ditonton video-video lainnya di channel Hore Kids ini. Terima kasih",
                imageUrl = "https://img.youtube.com/vi/KxKuWkUHSck/0.jpg",
                videoUrl = "https://www.youtube.com/embed/KxKuWkUHSck?autoplay=1&vq=small"
            )
        )




        val layoutManager : RecyclerView.LayoutManager =  GridLayoutManager(this, 2)
        binding.rvPembelajaran.layoutManager = layoutManager
        adapter = PembelajaranAdapter(this@PembelajaranActivity, pembelajaranList)
        adapter.setOnClick {
            val intent = Intent(this, DetailPembelajaran::class.java)
            intent.putExtra("title", it.title)
            intent.putExtra("description", it.description)
            intent.putExtra("imageUrl", it.imageUrl)
            intent.putExtra("videoUrl", it.videoUrl)
            startActivity(intent)
        }
        binding.rvPembelajaran.adapter = adapter

    }


}