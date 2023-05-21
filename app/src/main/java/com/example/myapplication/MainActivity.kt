package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.ui.DashboardActivity
import com.example.myapplication.ui.JadwalUmumActivity
import com.example.myapplication.ui.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLogin1 = findViewById<Button>(R.id.LoginBtn)
        val buttonLogin2 = findViewById<Button>(R.id.btnJadwalUmum)

        buttonLogin1.setOnClickListener {
            moveToDashboard()
        }

        buttonLogin2.setOnClickListener {
            moveToJadwalUmum()
        }
    }

    private fun moveToDashboard(){
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun moveToJadwalUmum(){
        startActivity(Intent(this, JadwalUmumActivity::class.java))
    }
}