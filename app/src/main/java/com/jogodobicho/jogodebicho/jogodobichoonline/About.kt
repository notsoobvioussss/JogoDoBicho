package com.jogodobicho.jogodebicho.jogodobichoonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jogodobicho.jogodebicho.jogodobichoonline.databinding.ActivityAboutBinding

class About : AppCompatActivity() {
    lateinit var about_bind: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        about_bind = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(about_bind.root)
        about_bind.backH1.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
        about_bind.prh1.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
        about_bind.neh1.setOnClickListener {
            startActivity(Intent(this, About2::class.java))
        }
    }
}