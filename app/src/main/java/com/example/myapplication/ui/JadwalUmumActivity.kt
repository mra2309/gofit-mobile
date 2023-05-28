package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.client.ApiClient
import com.example.myapplication.model.response.IzinListResponse
import com.example.myapplication.model.response.JadwalHarianResponse
import com.example.myapplication.model.response.JadwalUmumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JadwalUmumActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Jadwal Umum");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_umum);

        val backHome = findViewById<Button>(R.id.btnBackDashboardJadwalUmum)
//
        backHome.setOnClickListener {
            moveToDashboard()
        }

        getJadwalHariIni()
    }

    private fun moveToDashboard(){
        startActivity(Intent(this,MainActivity::class.java))
    }

    private fun getJadwalHariIni(){
        val call = ApiClient.getApiService().getJadwalUmum()
        call.enqueue(object : Callback<JadwalUmumResponse> {
            override fun onResponse(
                call: Call<JadwalUmumResponse>,
                response: Response<JadwalUmumResponse>
            ) {
                showMessage("Success Load Data")
                val res =  response.body()
                Log.e("failer", res!!.data.toString())
                var displayResponse = "";
                var jadwalData = listOf("");
                var listofVehicleNames = arrayListOf("")

                res.data?.forEach{
                    Log.e("id",it!!.idKelas.toString())
                    jadwalData.add(it!!.idKelas.toString());
                    listofVehicleNames.add(it!!.hari.toString()+" - "+it!!.waktu.toString()+" - "+it!!.jenisKelas.toString())
                }

                Log.e("data", listofVehicleNames.toString())

                val listViewApi: ListView = findViewById(R.id.listViewJadwalUmum)
                listViewApi.adapter = ArrayAdapter(this@JadwalUmumActivity,
                    android.R.layout.simple_list_item_1, listofVehicleNames)
            }



            override fun onFailure(call: Call<JadwalUmumResponse>, t: Throwable) {
                showMessage("eror other!")
                Log.e("failer", t.message!!)
            }

        })
    }

    private fun moveToPengajuan(){
        startActivity(Intent(this,IzinPengajuanActivity::class.java))
    }

    private fun showMessage(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    private fun <E> List<E>.add(e: E) {}

}