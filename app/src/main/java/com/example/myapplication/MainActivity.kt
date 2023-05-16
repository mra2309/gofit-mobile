package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.ui.DashboardActivity
import com.example.myapplication.ui.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLogin1 = findViewById<Button>(R.id.LoginBtn)

        buttonLogin1.setOnClickListener {
            moveToDashboard()
        }
    }

    private fun moveToDashboard(){
        startActivity(Intent(this, LoginActivity::class.java))
    }
}