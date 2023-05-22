package com.example.myapplication.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Message
import android.util.Log
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



        lateinit var sharedPreferences: SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
        email = sharedPreferences.getString(EMAIL_KEY, "").toString()
        pwd = sharedPreferences.getString(PWD_KEY, "").toString()
        usernames = sharedPreferences.getString(USERNAMAE, "").toString()
        user_id = sharedPreferences.getString(USER_ID, "").toString()
        role = sharedPreferences.getString(ROLE, "").toString()



        val loginRequest = LoginRequest(username,password);
        val call = ApiClient.getApiService().loginUser(loginRequest)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                Log.e("login response",response.toString());

                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    val user = loginResponse?.user ?: ""
                    Log.e("login response",user.toString());
                    // Token berhasil diterima, lakukan sesuatu di sini
                    showMessage("Login Berhasil !")

                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString(EMAIL_KEY, username.toString())
                    editor.putString(PWD_KEY, password.toString())
                    editor.putString(USERNAMAE, loginResponse!!.user!!.name.toString())
                    editor.putString(USER_ID, loginResponse!!.user!!.idUser.toString())
                    editor.putString(ROLE,loginResponse!!.user!!.role.toString())
                    editor.apply()

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