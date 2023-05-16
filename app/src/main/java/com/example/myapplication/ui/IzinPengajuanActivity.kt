package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class IzinPengajuanActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Form Pengajuan Izin");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_izin_pengajuan);

        val backHome = findViewById<Button>(R.id.buttonBack)

        val spinnerHari: Spinner = findViewById(R.id.spinnerHari)

        // Buat daftar nama hari
        val hariList = arrayOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu")

        // Buat adapter untuk Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, hariList)

        // Atur tampilan dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Terapkan adapter ke Spinner
        spinnerHari.adapter = adapter

        backHome.setOnClickListener {
            moveToIzin()
        }

    }

    private fun moveToIzin(){
        startActivity(Intent(this,IzinListActivity::class.java))
    }

}