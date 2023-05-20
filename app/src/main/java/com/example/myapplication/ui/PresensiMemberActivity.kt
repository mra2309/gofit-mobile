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
import com.example.myapplication.model.request.JadwalHarianRequest
import com.example.myapplication.model.response.JadwalHarianResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R.layout.simple_list_item_1


data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val description: String
)


class PresensiMemberActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.title = "Presensi Member"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presensi_member_list)

        val backHome = findViewById<Button>(R.id.btnBackHomePresensiMember)
        val presensiMasuk   = findViewById<Button>(R.id.btnPresensiMemberMasuk)
        val presensiPulang  = findViewById<Button>(R.id.btnPresensiMemberPulang)

        backHome.setOnClickListener {
            moveToDashboard()
        }

        presensiMasuk.setOnClickListener {
            //taruh fungsi presensi di sini
            showMessage("Presensi Masuk!")
        }

        presensiPulang.setOnClickListener {
            //taruh fungsi presensi di sini
            showMessage("Presensi Pulang!")
        }
        getJadwalHariIni()
    }

    private fun moveToDashboard() {
        startActivity(Intent(this,DashboardActivity::class.java))
    }

    private fun getJadwalHariIni(){
        val call = ApiClient.getApiService().getJadwalHarian()
        call.enqueue(object : Callback<JadwalHarianResponse> {
            override fun onResponse(
                call: Call<JadwalHarianResponse>,
                response: Response<JadwalHarianResponse>
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
                    listofVehicleNames.add(it!!.hariJadwalHarian.toString()+" - "+it!!.jenisKelas.toString())
                }

                Log.e("data", listofVehicleNames.toString())

                val listViewApi: ListView = findViewById(R.id.listViewPresensiMember)
                listViewApi.adapter = ArrayAdapter(this@PresensiMemberActivity, simple_list_item_1, listofVehicleNames)
            }



            override fun onFailure(call: Call<JadwalHarianResponse>, t: Throwable) {
                showMessage("eror other!")
                Log.e("failer", t.message!!)
            }

        })
    }


    private fun showMessage(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}

private fun <E> List<E>.add(e: E) {

}
