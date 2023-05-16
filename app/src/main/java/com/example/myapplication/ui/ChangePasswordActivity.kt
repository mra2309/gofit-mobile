package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class ChangePasswordActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Change Password");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password);

        val backHome = findViewById<Button>(R.id.btnBackHome)
        val changePassword = findViewById<Button>(R.id.buttonChangePasswordForm)

        backHome.setOnClickListener {
            moveToDashboard()
        }

        changePassword.setOnClickListener {
            changePassword()
        }

    }

    private fun moveToDashboard(){
        startActivity(Intent(this,DashboardActivity::class.java))
    }

    private fun changePassword(){
        showMessage("change password");
    }

    private fun showMessage(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }


}