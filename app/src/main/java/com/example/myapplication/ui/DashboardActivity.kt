package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class DashboardActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Dashboard");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard);

        val listizin = findViewById<Button>(R.id.btnListIjin)
        val bookingkelas = findViewById<Button>(R.id.btnBookingKelas)
        val changepassword = findViewById<Button>(R.id.btnChangePassword)
        val logout = findViewById<Button>(R.id.buttonLogout)


        listizin.setOnClickListener {
            moveToIzin()
        }

        bookingkelas.setOnClickListener {
            moveToBokingKelas()
        }

        changepassword.setOnClickListener {
            moveToChangePassword()
        }

        logout.setOnClickListener {
            moveToLogin()
        }

    }

    private fun moveToIzin(){
        startActivity(Intent(this,IzinListActivity::class.java))
    }

    private fun moveToChangePassword(){
        startActivity(Intent(this,ChangePasswordActivity::class.java))
    }

    private fun moveToBokingKelas(){
        startActivity(Intent(this,BookingKelasListActivity::class.java))
    }

    private fun moveToLogin(){
        startActivity(Intent(this,LoginActivity::class.java))
    }
}