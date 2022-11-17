package com.example.democontextapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.pointzi.Pointzi

class MainActivity : AppCompatActivity() {
    private lateinit var bNext:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bNext = findViewById<Button>(R.id.bNext)
        bNext.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }
        Pointzi.setUserId("swarup@streethawk.com")
    }
}