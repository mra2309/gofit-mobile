package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class BookingKelasAddActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Form Booking");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_kelas_add);

        val backHome = findViewById<Button>(R.id.backBooking)

        backHome.setOnClickListener {
            moveTolIST()
        }
    }

    private fun moveTolIST(){
        startActivity(Intent(this,BookingKelasListActivity::class.java))
    }
}