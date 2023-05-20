package com.example.myapplication.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JadwalHarianRequest {

    @SerializedName("username")
    @Expose
    var username: String? = null

}