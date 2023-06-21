package com.example.mediapembelajaran.menu.kuis

import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mediapembelajaran.R
import com.example.mediapembelajaran.databinding.ActivityQuiz4Binding

class Quiz4Activity : AppCompatActivity() {
    lateinit var binding : ActivityQuiz4Binding
    var dropCount1 = 0
    var dropCount2 = 0
    var dropCount3 = 0
    var dropCount4 = 0
    var dropCount5 = 0
    var dropCount6 = 0
    var dropCount7 = 0
    var dropCount8 = 0
    var dropCount9 = 0
    var dropCount10 = 0
    var dropCount11 = 0
    var dropCount12 = 0


    var dialogBuilder: AlertDialog.Builder? = null
    var alertDialog: AlertDialog? = null

    var benar = true
    lateinit var initialLayoutParams: ViewGroup.LayoutParams
    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        score = intent.getIntExtra("score", score)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        initialLayoutParams = binding.root.layoutParams
        drag1()
        drag2()
        drag3()
        drag4()
        drag5()
        drag6()
        drag7()
        drag8()
        drag9()
        drag10()
    }


    fun drag1(){
        binding.ivDrag1?.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            binding.ivDrag1?.visibility = View.GONE
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

                    resetLayoutPosition()

                    v.invalidate()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)

                    view.visibility = View.VISIBLE

                    if (destination == binding.gridAnswerBox) {
                        dropCount1++
                    } else if (destination == binding.gridAnswer) {
                        dropCount1--
                    }


                    checkAllDropsCompleted()
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    val view = event.localState as View
                    if (!event.result || dropCount1 < 1) {
                        view.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        binding.gridAnswerBox?.setOnDragListener(dragListener)
    }

    fun drag2(){
        binding.ivDrag2?.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            binding.ivDrag2?.visibility = View.GONE
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

                    resetLayoutPosition()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)

                    view.visibility = View.VISIBLE

                    if (destination == binding.gridAnswerBox) {
                        dropCount2++
                    } else if (destination == binding.gridAnswer) {
                        dropCount2--
                    }


                    checkAllDropsCompleted()
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    val view = event.localState as View
                    if (!event.result || dropCount2 < 1) {
                        view.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        binding.gridAnswerBox?.setOnDragListener(dragListener)
    }

    fun drag3(){
        binding.ivDrag3?.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            binding.ivDrag3?.visibility = View.GONE
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

                    resetLayoutPosition()
                    v.invalidate()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)

                    view.visibility = View.VISIBLE

                    if (destination == binding.gridAnswerBox) {
                        dropCount3++
                    } else if (destination == binding.gridAnswer) {
                        dropCount3--
                    }


                    checkAllDropsCompleted()
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    val view = event.localState as View
                    if (!event.result || dropCount3 < 1) {
                        view.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        binding.gridAnswerBox?.setOnDragListener(dragListener)
    }

    fun drag4(){
        binding.ivDrag4?.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            binding.ivDrag4?.visibility = View.GONE
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

                    resetLayoutPosition()
                    v.invalidate()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)

                    view.visibility = View.VISIBLE

                    if (destination == binding.gridAnswerBox) {
                        dropCount4++
                    } else if (destination == binding.gridAnswer) {
                        dropCount4--
                    }


                    checkAllDropsCompleted()
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    val view = event.localState as View
                    if (!event.result || dropCount4 < 1) {
                        view.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        binding.gridAnswerBox?.setOnDragListener(dragListener)
    }

    fun drag5(){
        binding.ivDrag5?.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            binding.ivDrag5?.visibility = View.GONE
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

                    resetLayoutPosition()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)

                    view.visibility = View.VISIBLE

                    if (destination == binding.gridAnswerBox) {
                        dropCount5++
                    } else if (destination == binding.gridAnswer) {
                        dropCount5--
                    }


                    checkAllDropsCompleted()
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    val view = event.localState as View
                    if (!event.result || dropCount5 < 1) {
                        view.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        binding.gridAnswerBox?.setOnDragListener(dragListener)
    }

    fun drag6(){
        binding.ivDrag6?.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            binding.ivDrag6?.visibility = View.GONE
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

                    resetLayoutPosition()
                    v.invalidate()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)

                    view.visibility = View.VISIBLE

                    if (destination == binding.gridAnswerBox) {
                        dropCount6++
                    } else if (destination == binding.gridAnswer) {
                        dropCount6--
                    }


                    checkAllDropsCompleted()
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    val view = event.localState as View
                    if (!event.result || dropCount6 < 1) {
                        view.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        binding.gridAnswerBox?.setOnDragListener(dragListener)
    }

    fun drag7(){
        binding.ivDrag7?.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            binding.ivDrag7?.visibility = View.GONE
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

                    resetLayoutPosition()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)

                    view.visibility = View.VISIBLE

                    if (destination == binding.gridAnswerBox) {
                        dropCount7++
                    } else if (destination == binding.gridAnswer) {
                        dropCount7--
                    }


                    checkAllDropsCompleted()
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    val view = event.localState as View
                    if (!event.result || dropCount7 < 1) {
                        view.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        binding.gridAnswerBox?.setOnDragListener(dragListener)
    }

    fun drag8(){
        binding.ivDrag8?.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            binding.ivDrag8?.visibility = View.GONE
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

                    resetLayoutPosition()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)

                    view.visibility = View.VISIBLE

                    if (destination == binding.gridAnswerBox) {
                        dropCount8++
                    } else if (destination == binding.gridAnswer) {
                        dropCount8--
                    }


                    checkAllDropsCompleted()
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    val view = event.localState as View
                    if (!event.result || dropCount8 < 1) {
                        view.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        binding.gridAnswerBox?.setOnDragListener(dragListener)
    }

    fun drag9(){
        binding.ivDrag9?.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            binding.ivDrag9?.visibility = View.GONE
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
                    resetLayoutPosition()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)

                    view.visibility = View.VISIBLE

                    if (destination == binding.gridAnswerBox) {
                        dropCount9++
                    } else if (destination == binding.gridAnswer) {
                        dropCount9--
                    }


                    checkAllDropsCompleted()
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    val view = event.localState as View
                    if (!event.result || dropCount9 < 1) {
                        view.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        binding.gridAnswerBox?.setOnDragListener(dragListener)
    }

    fun drag10(){
        binding.ivDrag10?.setOnLongClickListener {
            val clipText = "Terisi"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)
            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            binding.ivDrag10?.visibility = View.GONE
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
                    resetLayoutPosition()

                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)

                    val destination = v as GridLayout
                    destination.addView(view)

                    view.visibility = View.VISIBLE

                    if (destination == binding.gridAnswerBox) {
                        dropCount10++
                    } else if (destination == binding.gridAnswer) {
                        dropCount10--
                    }


                    checkAllDropsCompleted()
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    v.invalidate()
                    val view = event.localState as View
                    if (!event.result || dropCount10 < 1) {
                        view.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        binding.gridAnswerBox?.setOnDragListener(dragListener)
    }

    private fun checkAllDropsCompleted() {
        val totalDropCount = dropCount1 +
                dropCount2 +
                dropCount3 +
                dropCount4 +
                dropCount5 +
                dropCount6 +
                dropCount7 +
                dropCount8 +
                dropCount9 +
                dropCount10
        val expectedDropCount = 3 // Jumlah drop yang diharapkan
        var scoreHasil = 0
        benar = if (totalDropCount == expectedDropCount && binding.gridAnswerBox?.childCount == expectedDropCount) {
            //Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show()
            scoreHasil = score + 1
            true
        } else {
            scoreHasil = intent.getIntExtra("score", 0)
            //Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
            false
        }

        binding.btnNext?.setOnClickListener {
            //Toast.makeText(this, scoreHasil.toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Quiz5Activity::class.java)
            intent.putExtra("score", scoreHasil)
            startActivity(intent)
        }
    }

    fun dialogBenar(){
        dialogBuilder = AlertDialog.Builder(this)
        val layoutView: View = layoutInflater.inflate(R.layout.dialog_postive_layout, null)
        val dialogButton: Button = layoutView.findViewById(R.id.btnDialog)
        dialogBuilder!!.setView(layoutView)
        alertDialog = dialogBuilder!!.create()
        alertDialog!!.window!!.attributes.windowAnimations = R.style.Base_Theme_MediaPembelajaran
        alertDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog!!.show()
        dialogButton.setOnClickListener {
            alertDialog!!.dismiss()
            startActivity(Intent(this, Quiz5Activity::class.java))
            finish()
        }
    }

    private fun resetLayoutPosition() {
        binding.root.layoutParams = initialLayoutParams
    }
}