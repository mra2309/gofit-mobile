package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.client.ApiClient
import com.example.myapplication.model.response.BookingGymResponse
import com.example.myapplication.model.response.IzinListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingGymActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Booking Kelas Gym");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_list);

        val backHome = findViewById<Button>(R.id.btnBackHomeGym)
        val addbooking = findViewById<Button>(R.id.buttonAddGymList)

        backHome.setOnClickListener {
            moveToDashboard()
        }

        addbooking.setOnClickListener {
            moveToFormBokingGym()
        }

        getDataGym()
    }

    private fun moveToDashboard() {
        startActivity(Intent(this,DashboardActivity::class.java))
    }

    private fun getDataGym(){
        val call = ApiClient.getApiService().getBookingGym()
        call.enqueue(object : Callback<BookingGymResponse> {
            override fun onResponse(
                call: Call<BookingGymResponse>,
                response: Response<BookingGymResponse>
            ) {
                showMessage("Success Load Data")
                val res =  response.body()
                Log.e("failer", res!!.data.toString())
                var displayResponse = "";
                var jadwalData = listOf("");
                var listofVehicleNames = arrayListOf("")

                res.data?.forEach{
                    Log.e("id",it!!.nama.toString())
                    jadwalData.add(it!!.tanggal.toString());
                    listofVehicleNames.add(
                        it!!.tanggal.toString()+" - "+
                        it!!.nama.toString()+" - "+
                        it!!.slotWaktu.toString())
                }

                Log.e("data", listofVehicleNames.toString())

                val listViewApi: ListView = findViewById(R.id.listViewGymLyst)
                listViewApi.adapter = ArrayAdapter(this@BookingGymActivity, android.R.layout.simple_list_item_1, listofVehicleNames)
            }



            override fun onFailure(call: Call<BookingGymResponse>, t: Throwable) {
                showMessage("eror other!")
                Log.e("failer", t.message!!)
            }

        })
    }

    private fun showMessage(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    private fun moveToFormBokingGym() {
        startActivity(Intent(this,BookingGymAddActivity::class.java))
    }
}