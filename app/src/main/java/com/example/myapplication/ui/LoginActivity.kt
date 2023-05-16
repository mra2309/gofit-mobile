package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.client.ApiClient
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.model.request.LoginRequest
import com.example.myapplication.model.response.LoginResponse
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit


class LoginActivity:AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTitle("Login");
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login);

        val proseslogin = findViewById<Button>(R.id.btnLogin)
        val dashboardbtn = findViewById<Button>(R.id.btnforceDashboard)

        proseslogin.setOnClickListener {
            val username = findViewById<EditText>(R.id.edtUsername)
            val password = findViewById<EditText>(R.id.edtPassword)

            if(username.text.trim().isNotEmpty()&&password.text.trim().isNotEmpty()){
                showMessage("proses login tunggu sebentar ...")
                loginUser(username.text.toString(),password.text.trim().toString());
            }else{
                showMessage("ini Username dan password ...")
            }
        }

        dashboardbtn.setOnClickListener {
            moveToDashboard()
        }

    }

    private fun initData() {
        showMessage("mantap");
        clickListener()
    }

    private fun clickListener() {
        binding.btnLogin.setOnClickListener {
            getInputs();
        }
    }

    private fun getInputs() {
        val username = binding.edtUsername.text.toString();
        val password = binding.edtPassword.text.toString();


        if(username.isNotEmpty()&&password.isNotEmpty()){
            showMessage("get input")
        }else{
            showMessage("ini Username dan password ...")
        }
    }

    private fun loginUser(username:String,password:String){
        val loginRequest = LoginRequest(username,password);
        val call = ApiClient.getApiService().loginUser(loginRequest)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    val token = loginResponse?.token ?: ""
                    // Token berhasil diterima, lakukan sesuatu di sini
                    showMessage("Login Berhasil !")
                    moveToDashboard();
                } else {
                    // Tangani jika respons tidak sukses
                    showMessage("Username dan password tidak sesuai")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                showMessage("Tidak Terhubung Ke api ( OTHER EROR )")
            }
        })
    }

    private fun showMessage(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    private fun moveToDashboard(){
        startActivity(Intent(this,DashboardActivity::class.java))
    }
}