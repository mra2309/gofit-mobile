package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class IzinListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Izin List");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_izin_list);

        val backHome = findViewById<Button>(R.id.btnBackHomeIzin)
        val izin = findViewById<Button>(R.id.buttonAddIzin)

        backHome.setOnClickListener {
            moveToDashboard()
        }

        izin.setOnClickListener {
            moveToPengajuan()
        }
    }

    private fun moveToDashboard(){
        startActivity(Intent(this,DashboardActivity::class.java))
    }

    private fun moveToPengajuan(){
        startActivity(Intent(this,IzinPengajuanActivity::class.java))
    }

}