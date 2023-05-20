package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.myapplication.R

class PresensiInstrukturActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Presensi Instruktur");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presensi_instruktur_list);

        val backHome = findViewById<Button>(R.id.btnBackHomePresensiInstruktur)

        val presensiMasuk   = findViewById<Button>(R.id.btnPresensiInstrukturMasuk)
        val presensiPulang  = findViewById<Button>(R.id.btnPresensiInstrukturPulang)

        presensiMasuk.setOnClickListener {
            //taruh fungsi presensi di sini
            showMessage("Presensi Masuk!")
        }

        presensiPulang.setOnClickListener {
            //taruh fungsi presensi di sini
            showMessage("Presensi Pulang!")
        }

        backHome.setOnClickListener {
            moveToDashboard()
        }

    }

    private fun moveToDashboard() {
        startActivity(Intent(this,DashboardActivity::class.java))
    }


    private fun showMessage(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

}