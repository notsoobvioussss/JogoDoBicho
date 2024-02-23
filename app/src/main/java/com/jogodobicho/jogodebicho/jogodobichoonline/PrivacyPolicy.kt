package com.jogodobicho.jogodebicho.jogodobichoonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jogodobicho.jogodebicho.jogodobichoonline.databinding.ActivityPrivacyPolicyBinding

class PrivacyPolicy : AppCompatActivity() {
    lateinit var pp_bind: ActivityPrivacyPolicyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pp_bind = ActivityPrivacyPolicyBinding.inflate(layoutInflater)
        setContentView(pp_bind.root)
        pp_bind.backPp.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }
    }
}