package com.example.myapplication.client

import com.example.myapplication.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {


    fun getRetrofit(): Retrofit{

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client  = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:8000/")
            .client(client)
            .build()

        return  retrofit
    }

    fun getApiService(): ApiService{
        return getRetrofit().create(ApiService::class.java)
    }
}