package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class BookingGymActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Booking Kelas Gym");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_list);

        val backHome = findViewById<Button>(R.id.btnBackHomeGym)
        val addbooking = findViewById<Button>(R.id.buttonAddGym)

        backHome.setOnClickListener {
            moveToDashboard()
        }


        addbooking.setOnClickListener {
            moveToFormBokingGym()
        }
    }

    private fun moveToDashboard() {
        startActivity(Intent(this,DashboardActivity::class.java))
    }

    private fun moveToFormBokingGym() {
        startActivity(Intent(this,BookingGymAddActivity::class.java))
    }
}