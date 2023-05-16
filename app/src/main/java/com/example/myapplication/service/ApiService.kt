package com.example.myapplication.service

import com.example.myapplication.model.request.*
import com.example.myapplication.model.response.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.GET

interface ApiService {
    @POST("/api/login")
    fun loginUser(@Body request: LoginRequest):Call<LoginResponse>

    @POST("/api/logout")
    fun logout(@Body request: LogoutRequest):Call<LogoutResponse>

    @POST("/api/members/resetPassword?")
    fun resetPassword(@Body request: ResetPasswordRequest):Call<ResetPasswordResponse>

    @GET("/api/izin")
    fun list_izin(@Body request: LoginRequest):Call<IzinListResponse>

    @FormUrlEncoded
    @POST("/api/izin")
    fun form_izin(@Body request: IzinFormRequest):Call<IzinFormResponse>

    @GET("/api/booking")
    fun list_booking(@Body request: BookingListRequest):Call<BookingListResponse>

    @FormUrlEncoded
    @POST("/api/booking")
    fun form_booking(@Body request: BookingFormRequest):Call<BookingFormResponse>


}