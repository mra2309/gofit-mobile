package com.example.myapplication.model.response

data class LogoutResponse (
    var id:Int,
    var username:String,
    var email:String,
    var firstName:String,
    var lastName:String,
    var token:String

)