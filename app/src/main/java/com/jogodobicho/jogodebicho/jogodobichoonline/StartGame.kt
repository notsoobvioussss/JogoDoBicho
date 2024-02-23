package com.jogodobicho.jogodebicho.jogodobichoonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jogodobicho.jogodebicho.jogodobichoonline.databinding.ActivityStartGameBinding

class StartGame : AppCompatActivity() {
    lateinit var start_bind: ActivityStartGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        start_bind = ActivityStartGameBinding.inflate(layoutInflater)
        setContentView(start_bind.root)
        start_bind.start.setOnClickListener {
            startActivity(Intent(this, Starter::class.java))
        }
        start_bind.backSt1.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
        start_bind.lvl1.setOnClickListener {
            startActivity(Intent(this, Level1::class.java))
        }
        start_bind.lvl2.setOnClickListener {
            startActivity(Intent(this, Level2::class.java))
        }
        start_bind.lvl3.setOnClickListener {
            startActivity(Intent(this, Level3::class.java))
        }
        start_bind.lvl4.setOnClickListener {
            startActivity(Intent(this, Level4::class.java))
        }
        start_bind.lvl5.setOnClickListener {
            startActivity(Intent(this, Level5::class.java))
        }
        start_bind.lvl6.setOnClickListener {
            startActivity(Intent(this, Level6::class.java))
        }
    }
}