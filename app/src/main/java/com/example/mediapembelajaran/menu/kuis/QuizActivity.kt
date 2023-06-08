package com.example.mediapembelajaran.menu.kuis

import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuizBinding
    private var dropCount1 = 0
    private var dropCount2 = 0
    private var dropCount3 = 0
    private var dropCount4 = 0
    private var dropCount5 = 0
    private var dropCount6 = 0
    private var dropCount7 = 0
    private var dropCount8 = 0

    var benar = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()


    }

    fun init() {
        box1()
        box2()
        box3()

    }


    fun box1() {
        binding.dragView1.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            binding.dragView1.visibility = View.GONE
            true
        }

        val dragListener = View.OnDragListener { v, event ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                }

                DragEvent.ACTION_DRAG_ENTERED -> {
                    v.invalidate()
                    true
                }

                DragEvent.ACTION_DRAG_LOCATION -> true

                DragEvent.ACTION_DRAG_EXITED -> {
                    v.invalidate()
                    true
                }

                DragEvent.ACTION_DROP -> {
                    val item = event.clipData.getItemAt(0)
                    val dragData = item.text
                    //Toast.makeText(this@QuizActivity, dragData, Toast.LENGTH_SHORT).show()

                    v.invalidate()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)

                    view.visibility = View.VISIBLE

                    if (destination == binding.llBottom) {
                        dropCount1++
                    } else if (destination == binding.llTop) {
                        dropCount1--
                    }


                    checkAllDropsCompleted()
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    true
                }

                else -> false
            }
        }


        binding.llBottom.setOnDragListener(dragListener)
        binding.llTop.setOnDragListener(dragListener)
    }

    fun box2() {
        binding.dragView2.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            binding.dragView2.visibility = View.GONE
            true
        }

        val dragListener = View.OnDragListener { v, event ->
            when (event.action) {

                DragEvent.ACTION_DRAG_STARTED -> {
                    event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                }

                DragEvent.ACTION_DRAG_ENTERED -> {
                    v.invalidate()
                    true
                }

                DragEvent.ACTION_DRAG_LOCATION -> true

                DragEvent.ACTION_DRAG_EXITED -> {
                    v.invalidate()
                    true
                }

                DragEvent.ACTION_DROP -> {
                    val item = event.clipData.getItemAt(0)
                    val dragData = item.text
                    //Toast.makeText(this@QuizActivity, dragData, Toast.LENGTH_SHORT).show()

                    v.invalidate()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)
                    view.visibility = View.VISIBLE

                    if (destination == binding.llBottom) {
                        dropCount2++
                    } else if (destination == binding.llTop) {
                        dropCount2--
                    }

                    checkAllDropsCompleted()
                    true

                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    true
                }

                else -> false
            }
        }


        binding.llBottom.setOnDragListener(dragListener)
        binding.llTop.setOnDragListener(dragListener)
    }

    fun box3() {
        binding.dragView3.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            binding.dragView3.visibility = View.GONE
            true
        }

        val dragListener = View.OnDragListener { v, event ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                }

                DragEvent.ACTION_DRAG_ENTERED -> {
                    v.invalidate()
                    true
                }

                DragEvent.ACTION_DRAG_LOCATION -> true

                DragEvent.ACTION_DRAG_EXITED -> {
                    v.invalidate()
                    true
                }

                DragEvent.ACTION_DROP -> {
                    val item = event.clipData.getItemAt(0)
                    val dragData = item.text
                    //Toast.makeText(this@QuizActivity, dragData, Toast.LENGTH_SHORT).show()

                    v.invalidate()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)
                    view.visibility = View.VISIBLE

                    if (destination == binding.llBottom) {
                        dropCount2++
                    } else if (destination == binding.llTop) {
                        dropCount2--
                    }


                    checkAllDropsCompleted()
                    true

                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    true
                }

                else -> false
            }
        }

        binding.llBottom.setOnDragListener(dragListener)
        binding.llTop.setOnDragListener(dragListener)
    }


    private fun checkAllDropsCompleted() {
        val totalDropCount = dropCount1 + dropCount2 + dropCount3
        val expectedDropCount = 2 // Jumlah drop yang diharapkan

        if (totalDropCount == expectedDropCount && binding.llBottom.childCount == expectedDropCount) {
            Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show()
            benar = true
        } else {
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
            benar = false
        }

        if (benar) {
            binding.btnNext.setBackgroundColor(Color.GREEN)
        } else {
            binding.btnNext.setBackgroundColor(Color.DKGRAY)
        }


        binding.btnNext.setOnClickListener {
            if (benar == true){
                startActivity(Intent(this, Quiz1Activity::class.java))
            }else{
                Toast.makeText(this, "Tidak Bisa Lanjut karena jawaban belum benar", Toast.LENGTH_SHORT).show()
            }

        }

    }

}