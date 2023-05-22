package com.example.myapplication.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.client.ApiClient
import com.example.myapplication.model.request.BookingFormRequest
import com.example.myapplication.model.response.BookingFormResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingGymAddActivity:AppCompatActivity() {
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
        this.setTitle("add Pendaftaran Gym");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_add);

        val backHome = findViewById<Button>(R.id.btnBackHomeGymAdd)
        val saveBooking = findViewById<Button>(R.id.btnSaveGym)
        val tvTime = findViewById<EditText>(R.id.edtWaktuBooking)

        lateinit var sharedPreferences: SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        email = sharedPreferences.getString(EMAIL_KEY, null)!!
        usernames = sharedPreferences.getString(USERNAMAE, null)!!
        role = sharedPreferences.getString(ROLE, null)!!
        user_id = sharedPreferences.getString(USER_ID, null)!!

        Log.e("id member",user_id)


        backHome.setOnClickListener {
            moveToDashboard()
        }

        saveBooking.setOnClickListener {
            saveBookingGym(user_id,tvTime.text.toString())
        }

    }

    private fun moveToDashboard() {
        startActivity(Intent(this,BookingGymActivity::class.java))
    }

    private fun saveBookingGym(id_user:String,time:String){
        val BookingFormRequest = BookingFormRequest(id_user,time);
        val call = ApiClient.getApiService().saveBookingGym(BookingFormRequest)
        call.enqueue(object : Callback<BookingFormResponse> {
            override fun onResponse(call: Call<BookingFormResponse>, response: Response<BookingFormResponse>) {
                showMessage("Success Save Booking Gym");
                moveToDashboard()
            }

            override fun onFailure(call: Call<BookingFormResponse>, t: Throwable) {
                showMessage("Failed To Create Booking");
                Log.e("Eror",t.message.toString())
            }
        })
    }

    private fun showMessage(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

}