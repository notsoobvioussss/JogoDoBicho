package com.jogodobicho.jogodebicho.jogodobichoonline

import android.content.Intent
import android.os.Bundle
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class Level3 : AppCompatActivity() {
    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView
    private lateinit var image4: ImageView

    private lateinit var zone1: FrameLayout
    private lateinit var zone2: FrameLayout
    private lateinit var zone3: FrameLayout
    private lateinit var zone4: FrameLayout
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level3)
        image1 = findViewById(R.id.image13)
        image2 = findViewById(R.id.image23)
        image3 = findViewById(R.id.image33)
        image4 = findViewById(R.id.image43)

        zone1 = findViewById(R.id.zone13)
        zone2 = findViewById(R.id.zone23)
        zone3 = findViewById(R.id.zone33)
        zone4 = findViewById(R.id.zone43)
        setDragListener(zone1)
        setDragListener(zone2)
        setDragListener(zone3)
        setDragListener(zone4)

        setDragListener(image1)
        setDragListener(image2)
        setDragListener(image3)
        setDragListener(image4)

        setTouchListener(image1)
        setTouchListener(image2)
        setTouchListener(image3)
        setTouchListener(image4)
        val ne1 = findViewById<ImageView>(R.id.ne3)
        val pr1 = findViewById<ImageView>(R.id.pr3)
        val back1 = findViewById<ImageView>(R.id.back3)
        ne1.setOnClickListener {
            startActivity(Intent(this, Level4::class.java))
        }
        pr1.setOnClickListener {
            startActivity(Intent(this, Level2::class.java))
        }
        back1.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
    }

    private fun setDragListener(view: View) {
        view.setOnDragListener { v, event ->
            when (event.action) {
                DragEvent.ACTION_DROP -> {
                    val draggedView = event.localState as View

                    if (v == zone1 && draggedView == image1) {
                        increaseCounter()
                        setImageInZone(v, draggedView)
                    } else if (v == zone2 && draggedView == image2) {
                        increaseCounter()
                        setImageInZone(v, draggedView)
                    } else if (v == zone3 && draggedView == image3) {
                        increaseCounter()
                        setImageInZone(v, draggedView)
                    } else if (v == zone4 && draggedView == image4) {
                        increaseCounter()
                        setImageInZone(v, draggedView)
                    }
                }
            }
            true
        }
    }

    private fun setTouchListener(view: View) {
        view.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val shadowBuilder = View.DragShadowBuilder(v)
                v.startDrag(null, shadowBuilder, v, 0)
                //v.visibility = View.INVISIBLE
                true
            } else {
                false
            }
        }
    }

    private fun increaseCounter() {
        counter++
        if (counter == 4) {
            openNewActivity()
        }
    }

    private fun setImageInZone(zone: View, image: View) {
        val parent = image.parent as? ViewGroup
        parent?.removeView(image)
        (zone as ViewGroup).removeAllViews()
        zone.addView(image)
        image.visibility = View.INVISIBLE
    }


    private fun openNewActivity() {
        val intent = Intent(this, Level4::class.java)
        startActivity(intent)
    }
}
