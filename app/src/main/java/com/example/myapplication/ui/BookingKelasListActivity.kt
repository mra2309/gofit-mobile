package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class BookingKelasListActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Booking Kelas List");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_kelas);

        val backHome = findViewById<Button>(R.id.btnBackHomeBooking)
        val addbooking = findViewById<Button>(R.id.buttonAddBooking)

        backHome.setOnClickListener {
            moveToDashboard()
        }


        addbooking.setOnClickListener {
            moveToFormBoking()
        }
    }

    private fun moveToDashboard() {
        startActivity(Intent(this,DashboardActivity::class.java))
    }

    private fun moveToFormBoking() {
        startActivity(Intent(this,BookingKelasAddActivity::class.java))
    }
}