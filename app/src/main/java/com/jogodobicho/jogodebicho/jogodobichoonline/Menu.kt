package com.jogodobicho.jogodebicho.jogodobichoonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jogodobicho.jogodebicho.jogodobichoonline.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    lateinit var menu_binding: ActivityMenuBinding
    var pass = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menu_binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(menu_binding.root)
        menu_binding.back.setOnClickListener {
            pass++
        }
        menu_binding.startGame.setOnClickListener {
            startActivity(Intent(this, StartGame::class.java))
        }
        menu_binding.contactus.setOnClickListener {
            startActivity(Intent(this, PrivacyPolicy::class.java))
        }
        menu_binding.privacypolicy.setOnClickListener {
            startActivity(Intent(this, ContactUs::class.java))
        }
        menu_binding.about.setOnClickListener {
            startActivity(Intent(this, About::class.java))
        }
    }
}