package com.example.myapplication.model.response

data class LoginResponse (
    var id:Int,
    var username:String,
    var email:String,
    var firstName:String,
    var lastName:String,
    var token:String

)