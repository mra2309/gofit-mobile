package com.example.myapplication.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class DashboardActivity: AppCompatActivity() {

    var PREFS_KEY = "prefs"
    var EMAIL_KEY = "email"
    var PWD_KEY = "pwd"
    var USERNAMAE = "usernames"
    var USER_ID = "user_id"
    var ROLE = "role"

    var email = ""
    var pwd = ""
    var usernames = ""
    var user_id = ""
    var role = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var sharedPreferences: SharedPreferences

        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        email = sharedPreferences.getString(EMAIL_KEY, null)!!
        usernames = sharedPreferences.getString(USERNAMAE, null)!!
        role = sharedPreferences.getString(ROLE, null)!!


        this.setTitle("Dashboard");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard);


        val usetTv            = findViewById<TextView>(R.id.textViewUsername)
        val emailTv            = findViewById<TextView>(R.id.textViewEmail)
        val roleTv                = findViewById<TextView>(R.id.textViewPhone)

        usetTv.setText("Username : $usernames");
        emailTv.setText("Email : $email");
        roleTv.setText("Role : $role");


        val aktifitas            = findViewById<Button>(R.id.btnHistory)

        val listizin            = findViewById<Button>(R.id.btnListIjin)
        val bookingkelas        = findViewById<Button>(R.id.btnBookingKelas)
        val bookingGym          = findViewById<Button>(R.id.btnBookingGym)

        val presensiMember      = findViewById<Button>(R.id.btnPresentiMember)
        val presensiInstruktur  = findViewById<Button>(R.id.btnPresensiInstruktur)

        val changepassword      = findViewById<Button>(R.id.btnChangePassword)
        val logout              = findViewById<Button>(R.id.buttonLogout)


        if(role=="Member"){
            changepassword.setVisibility(View.GONE);
            presensiInstruktur.setVisibility(View.GONE);
        }

        aktifitas.setOnClickListener {
            moveToHistiory()
        }

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

        bookingGym.setOnClickListener {
            moveToGym()
        }

        presensiMember.setOnClickListener {
            moveToPresensiMember()
        }

        presensiInstruktur.setOnClickListener {
            moveToPresensiInstruktur()
        }

    }

    private fun moveToPresensiMember(){
        startActivity(Intent(this,PresensiMemberActivity::class.java))
    }

    private fun moveToPresensiInstruktur(){
        startActivity(Intent(this,PresensiInstrukturActivity::class.java))
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

    private fun moveToGym(){
        startActivity(Intent(this,BookingGymActivity::class.java))
    }

    private fun moveToHistiory(){
        startActivity(Intent(this,HistoryActivity::class.java))
    }
}