package com.example.mediapembelajaran.menu.pembelajaran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mediapembelajaran.MainActivity
import com.example.mediapembelajaran.adapter.PembelajaranAdapter
import com.example.mediapembelajaran.databinding.ActivityPembelajaranBinding
import com.example.mediapembelajaran.model.PembelajaranModels

class PembelajaranActivity : AppCompatActivity() {
    lateinit var binding: ActivityPembelajaranBinding
    lateinit var adapter: PembelajaranAdapter
    var pembelajaranList: ArrayList<PembelajaranModels> = ArrayList()
    var tema = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPembelajaranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tema = intent.getStringExtra("tema").toString()
        Log.d("TAG", "Tema  -->: " + tema)

        init(tema)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MateriActivity::class.java))
            finish()
        }
    }

    private fun init(tema: String){
        when (tema) {
            "tema1" -> {
                dataTema1()
            }
            "tema2" -> {
                dataTema2()
            }
            "tema3" -> {
                dataTema3()
            }
            "tema4" -> {
                dataTema4()
            }
            "tema5" -> {
                dataTema5()
            }
        }

        val layoutManager : RecyclerView.LayoutManager =  LinearLayoutManager(this)
        binding.rvPembelajaran.layoutManager = layoutManager
        adapter = PembelajaranAdapter(this@PembelajaranActivity, pembelajaranList)
        adapter.setOnClick {
            val intent = Intent(this, DetailPembelajaran::class.java)
            intent.putExtra("title", it.title)
            intent.putExtra("description", it.description)
            intent.putExtra("imageUrl", it.imageUrl)
            intent.putExtra("videoUrl", it.videoUrl)
            intent.putExtra("tema", tema)
            startActivity(intent)
        }
        binding.rvPembelajaran.adapter = adapter

    }

    fun dataTema1(){
        pembelajaranList.add(
            PembelajaranModels(
                title = "A B C - Bus Tayo Lagu belajar sambil bernyanyi terbaru Learn Toys Friends mobil balita",
                description = "Video ini pembelajaran A B C - Bus Tayo Lagu belajar sambil bernyanyi terbaru Learn Toys Friends mobil balita",
                imageUrl = "https://img.youtube.com/vi/iRC6QBcqn7M/0.jpg",
                videoUrl = "https://www.youtube.com/embed/iRC6QBcqn7M?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Belajar angka dan berhitung untuk anak-anak ",
                description = "Video Belajar Berhitung angka 1-50 bersama upin ipin",
                imageUrl = "https://img.youtube.com/vi/0fNeeYcTwJI/0.jpg",
                videoUrl = "https://www.youtube.com/embed/0fNeeYcTwJI?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Belajar Mengenal Angka",
                description = "Video Belajar Mengenal Angka",
                imageUrl = "https://img.youtube.com/vi/uuO7e4Qg8vY/0.jpg",
                videoUrl = "https://www.youtube.com/embed/uuO7e4Qg8vY?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "KONSEP PEMBAGIAN KELAS 2",
                description = "Video Belajar Mengenal Pembagian",
                imageUrl = "https://img.youtube.com/vi/W2ZRiaZrSe0/0.jpg",
                videoUrl = "https://www.youtube.com/embed/W2ZRiaZrSe0?autoplay=1&vq=smalll"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Mengenal Bentuk Bangun Ruang",
                description = "video pembelajaran ini berisikan materi tentang Mengenal Bentuk Bangun Ruang.",
                imageUrl = "https://img.youtube.com/vi/TPy8zfIVZ5w/0.jpg",
                videoUrl = "https://www.youtube.com/embed/TPy8zfIVZ5w/?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Bangun Datar dan Bangun Ruang Kelas 2 SD",
                description = "Video ini untuk mengenal dan tahu ciri-ciri Bangun Datar dan Bangun Ruang.",
                imageUrl = "https://img.youtube.com/vi/X8JKU6A0kG0/0.jpg",
                videoUrl = "https://www.youtube.com/embed/X8JKU6A0kG0/?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "UPIN IPIN | MENGHAFAL PERKALIAN 1-10 DENGAN LAGU",
                description = "Video ini Berisi Menghafal Perkalian sangat penting. Perkalian adalah kunci keberhasilan dalam Matematika.",
                imageUrl = "https://img.youtube.com/vi/WxLIdIPcrwg/0.jpg",
                videoUrl = "https://www.youtube.com/embed/WxLIdIPcrwg?autoplay=1&vq=smalll"
            )
        )
    }


    fun dataTema2(){
        pembelajaranList.add(
            PembelajaranModels(
                title = "VIDEO ANIMASI PEMBELAJARAN MATEMATIKA ( SOAL CERITA PERKALIAN - KELAS 2 )",
                description = "VIDEO ANIMASI PEMBELAJARAN MATEMATIKA ( SOAL CERITA PERKALIAN - KELAS 2 ) Pada video ini, ibu mengajarkan bagaimana cara memahami dan menyelesaikan soal cerita perkalian. Semoga video ini bisa bermanfaat untuk belajar anak-anak",
                imageUrl = "https://img.youtube.com/vi/26SV2VBQizQ/0.jpg",
                videoUrl = "https://www.youtube.com/embed/26SV2VBQizQ?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Cara Membaca Jam - Materi Pembelajaran Kelas 2 SD",
                description = "Halo anak - anak, Video pertama ini saya akan membagikan bagaimana cara membaca jam dan penulisan secara baik dan benar. Belajar membaca jam sangat penting untuk di pelajari, khususnya anak - anak yang masih bingung membaca jam. Mudah mudahan dengan adanya video pembelajaran ini anak - anak lebih mudah membaca jam.",
                imageUrl = "https://img.youtube.com/vi/wlkup6RYGAM/0.jpg",
                videoUrl = "https://www.youtube.com/embed/wlkup6RYGAM?autoplay=1&vq=smalll"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "KELAS 2 - SATUAN PANJANG",
                description = "Video ini berisi untuk mengenal satuan panjang dalam suatu tempat dan benda di sekitar.",
                imageUrl = "https://img.youtube.com/vi/feu1DIeXT_Y/0.jpg",
                videoUrl = "https://www.youtube.com/embed/feu1DIeXT_Y?autoplay=1&vq=smalll"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Lagu Satuan Berat Mupel Matematika Kelas 2 SD Tema 6",
                description = "Video ini berisi tentang lagu Kalau Kau Suka Hati dengan lirik satuan berat, memudahkan siswa menghafal satuan berat.",
                imageUrl = "https://img.youtube.com/vi/1usUa2fc144/0.jpg",
                videoUrl = "https://www.youtube.com/embed/1usUa2fc144?autoplay=1&vq=smallll"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "MENGUKUR BERAT BENDA KILOGRAM DAN ONS KELAS 2 SD",
                description = "Video ini berisi tentang mengukur berat benda Kilogram dan Ons kelas 2 dalam bentuk animasi",
                imageUrl = "https://img.youtube.com/vi/26SV2VBQizQ/0.jpg",
                videoUrl = "https://www.youtube.com/embed/IvycS1Qsdq8?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "MENGENAL SATUAN WAKTU KELAS 2 SD || Jam, Hari, Minggu, Bulan",
                description = "Video matematika mengenal satuan waktu merupakan materi untuk anak kelas 2 SD. Di dalam video ini dijelaskan konversi waktu jam dan  hari, hari dan minggu, serta hari dan bulan.",
                imageUrl = "https://img.youtube.com/vi/TlhlLySucAc/0.jpg",
                videoUrl = "https://www.youtube.com/embed/IvycS1Qsdq8?autoplay=1&vq=smallll"
            )
        )
    }

    fun dataTema3(){
        pembelajaranList.add(
            PembelajaranModels(
                title = "MENGENAL PECAHAN DARI SEKELOMPOK BENDA || PART 2",
                description = "video kali ini kita akan belajar matematika tentang mengenal pecahan dari sekelompok benda",
                imageUrl = "https://img.youtube.com/vi/IVPplPg2taA/0.jpg",
                videoUrl = "https://www.youtube.com/embed/IVPplPg2taA?autoplay=1&vq=smallll"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "MENGENAL PEMBAGIAN - Matematika Kelas 2 SD",
                description = "Di video ini diajarkan konsep pembagian sebagai pengurangan berulang. Di video ini juga ada latihan soal pembagian.",
                imageUrl = "https://img.youtube.com/vi/dzeN4JQG71o/0.jpg",
                videoUrl = "https://www.youtube.com/embed/dzeN4JQG71o?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "PENJUMLAHAN BERSUSUN - Cara Panjang dan Cara Pendek",
                description = "video kali ini kita akan belajar matematika penjumlahan bersusun. Penjumlahan bersusun cara panjang dan penjumlahan bersusun cara pendek. Di video ini kita juga latihan soal penjumlahan bersusun.",
                imageUrl = "https://img.youtube.com/vi/ovCBfF0x11E/0.jpg",
                videoUrl = "https://www.youtube.com/embed/ovCBfF0x11E?autoplay=1&vq=smallll"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Pembagian dengan Cara Pengurangan Berulang - Kelas 2 SD",
                description = "Video ini berisi tentang pembagian dengan cara pengurangan berulang dengan Tema Bermain di Lingkunganku",
                imageUrl = "https://img.youtube.com/vi/qHl_U87-SFw/0.jpg",
                videoUrl = "https://www.youtube.com/embed/qHl_U87-SFw?autoplay=1&vq=smallll"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Pecahan | Matematika SD",
                description = "video kali ini kita akan belajar tentang bilangan pecahan dan bentuk-bentuk pecahan.",
                imageUrl = "https://img.youtube.com/vi/0hPRfqPFtt8/0.jpg",
                videoUrl = "https://www.youtube.com/embed/0hPRfqPFtt8?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Lagu Mengenal Bangun Datar",
                description = "Video ini berisi tentang lagu mengenal bangun datar. Musik dari Karaoke Pak Mul Musik",
                imageUrl = "https://img.youtube.com/vi/pd2IRQVFiM8/0.jpg",
                videoUrl = "https://www.youtube.com/embed/pd2IRQVFiM8?autoplay=1&vq=small"
            )
        )
    }

    fun dataTema4(){
        pembelajaranList.add(
            PembelajaranModels(
                title = "RUAS GARIS BANGUN DATAR KELAS 2 TEMA 4 SUBTEMA 1 PEMBELAJARAN 1",
                description = "Hallo semuanya, Berjumpa lagi di channel Nisfi Anisah, channelnya pembelajaran sekolah dasar. Pada kesempatan ini, saya ingin berbagi pembelajaran ruas garis bangun datar kelas 2 tema 4 subtema 1 pembelajaran 1. Materi pembelajaran ruas garis bangun datar, diambil dari buku tematik kelas 2 kurikulum 2013. Semoga dengan adanya video pembelajaran sekolah dasar ini dapat memudahkan bapak ibu guru, orangtua dan peserta didik kelas 2 dalam memahami materi ruas garis bangun datar kelas 2.",
                imageUrl = "https://img.youtube.com/vi/d81JgAQUqTE/0.jpg",
                videoUrl = "https://www.youtube.com/embed/d81JgAQUqTE?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Video Pembelajaran Matematika Kelas 2 Tema 4 Subtema 2",
                description = "Video pembelajaran matematika kelas 2 tema 4 subtema 2 Mengelompokkan bangun datar / Kelas 2 tema 4 subtema 1 pembelajaran 1",
                imageUrl = "https://img.youtube.com/vi/MZywmzGOKfY/0.jpg",
                videoUrl = "https://www.youtube.com/embed/MZywmzGOKfY?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Video Pembelajaran Matematika Kelas 2 Tema 4 Subtema 3",
                description = "Video Pembelajaran Matematika Kelas 2 Tema 4 Hidup bersih dan sehat Subtema 3 Hidup bersih dan sehat di tempat bermain Video Pembelajaran Matematika Kelas 2 Tema 4 Subtema 3 Ruas garis pada bangun ruang",
                imageUrl = "https://img.youtube.com/vi/1HiTqUQTjwE/0.jpg",
                videoUrl = "https://www.youtube.com/embed/1HiTqUQTjwE?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Video Pembelajaran Matematika Kelas 2 Tema 4 Subtema 4",
                description = "Video Pembelajaran Matematika Kelas 2 Tema 4 Hidup bersih dan sehat Subtema 4 Hidup bersih dan sehat di tempat umum Video Pembelajaran Matematika Kelas 2 Tema 4 Subtema 4 Unsur unsur bangun ruang",
                imageUrl = "https://img.youtube.com/vi/1NDChiV59WU/0.jpg",
                videoUrl = "https://www.youtube.com/embed/1NDChiV59WU?autoplay=1&vq=small"
            )
        )
    }

    fun dataTema5(){
        pembelajaranList.add(
            PembelajaranModels(
                title = "Video Pembelajaran Matematika Kelas 2 Tema 5 Subtema 1",
                description = "Video Pembelajaran Matematika Kelas 2 Tema 5 Subtema 1 Alat ukur panjang baku Kelas 2 tema 5 subtema 1 pembelajaran 1",
                imageUrl = "https://img.youtube.com/vi/eJ67XPIBtbY/0.jpg",
                videoUrl = "https://www.youtube.com/embed/eJ67XPIBtbY?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Video Pembelajaran Matematika Kelas 2 Tema 5 Subtema 2",
                description = "Video Pembelajaran Matematika Kelas 2 Tema 5 Subtema 2 Mengubah satuan ukuran panjang Kelas 2 tema 5 subtema 2 pembelajaran 1",
                imageUrl = "https://img.youtube.com/vi/A9rL5Zs-xIM/0.jpg",
                videoUrl = "https://www.youtube.com/embed/A9rL5Zs-xIM?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Video Pembelajaran Matematika Kelas 2 Tema 5 Subtema 3",
                description = "Video Pembelajaran Matematika Kelas 2 Tema 5 Subtema 3 Perbandingan panjan benda / Mengurutkan panjang benda Kelas 2 tema 5 subtema 3 pembelajaran 1",
                imageUrl = "https://img.youtube.com/vi/lqMr1G-aaS8/0.jpg",
                videoUrl = "https://www.youtube.com/embed/lqMr1G-aaS8?autoplay=1&vq=small"
            )
        )

        pembelajaranList.add(
            PembelajaranModels(
                title = "Video Pembelajaran Matematika Kelas 2 Tema 5 Subtema 4",
                description = "Video Pembelajaran Matematika Kelas 2 Tema 5 Subtema 4 Menyelesaikan masalah panjang benda Kelas 2 tema 5 subtema 4 pembelajaran 1",
                imageUrl = "https://img.youtube.com/vi/58Gme5UOsFE/0.jpg",
                videoUrl = "https://www.youtube.com/embed/58Gme5UOsFE?autoplay=1&vq=small"
            )
        )
    }


}