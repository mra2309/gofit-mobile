package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class BookingGymAddActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Form Pendaftaran Gym");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_add);

        val backHome = findViewById<Button>(R.id.btnBackHomeGymAdd)

        backHome.setOnClickListener {
            moveToDashboard()
        }

    }

    private fun moveToDashboard() {
        startActivity(Intent(this,DashboardActivity::class.java))
    }
}