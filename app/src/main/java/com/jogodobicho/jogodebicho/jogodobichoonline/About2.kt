package com.jogodobicho.jogodebicho.jogodobichoonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jogodobicho.jogodebicho.jogodobichoonline.databinding.ActivityAbout2Binding

class About2 : AppCompatActivity() {
    lateinit var about2_bind: ActivityAbout2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        about2_bind = ActivityAbout2Binding.inflate(layoutInflater)
        setContentView(about2_bind.root)
        about2_bind.backH2.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
        about2_bind.prh2.setOnClickListener {
            startActivity(Intent(this, About::class.java))
        }
    }
}