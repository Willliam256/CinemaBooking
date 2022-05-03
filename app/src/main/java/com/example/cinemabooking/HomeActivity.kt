package com.example.cinemabooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.*
import android.widget.Button
import androidx.core.content.ContextCompat

class HomeActivity : AppCompatActivity() {

    lateinit var btnContinue:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)

        window.decorView.apply { systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }

        btnContinue = findViewById(R.id.btn_continue)

        btnContinue.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}