package com.jogodobicho.jogodebicho.jogodobichoonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

class Starter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)
        val back_st = findViewById<ImageView>(R.id.back_st)
        back_st.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
        Handler().postDelayed({
            startActivity(Intent(this, Level1::class.java))
        }, 2000)
    }
}