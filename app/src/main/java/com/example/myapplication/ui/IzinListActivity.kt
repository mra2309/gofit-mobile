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
import com.example.myapplication.model.response.IzinListResponse
import com.example.myapplication.model.response.JadwalHarianResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        getDataIzin()
    }

    private fun moveToDashboard(){
        startActivity(Intent(this,DashboardActivity::class.java))
    }

    private fun getDataIzin(){
        val call = ApiClient.getApiService().getListIzin()
        call.enqueue(object : Callback<IzinListResponse> {
            override fun onResponse(
                call: Call<IzinListResponse>,
                response: Response<IzinListResponse>
            ) {
                showMessage("Success Load Data")
                val res =  response.body()
                Log.e("failer", res!!.data.toString())
                var displayResponse = "";
                var jadwalData = listOf("");
                var listofVehicleNames = arrayListOf("")

                res.data?.forEach{
                    Log.e("id",it!!.sesiIzin.toString())
                    jadwalData.add(it!!.tanggalIzin.toString());
                    listofVehicleNames.add(it!!.tanggalIzin.toString()+" - "+it!!.status.toString())
                }

                Log.e("data", listofVehicleNames.toString())

                val listViewApi: ListView = findViewById(R.id.listViewIzin)
                listViewApi.adapter = ArrayAdapter(this@IzinListActivity, android.R.layout.simple_list_item_1, listofVehicleNames)
            }



            override fun onFailure(call: Call<IzinListResponse>, t: Throwable) {
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