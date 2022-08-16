package com.application.vietlotteryeight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AboutPage : AppCompatActivity() {

        private var btnA : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        btnA = findViewById(R.id.btnA)
        btnA?.setOnClickListener{
            onBackPressed()
        }

    }
}