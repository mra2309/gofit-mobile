package com.example.myapplication.model.response

import com.google.gson.annotations.SerializedName

data class JadwalUmumResponse (
    @SerializedName("success" ) var success : Boolean?        = null,
    @SerializedName("message" ) var message : String?         = null,
    @SerializedName("data"    ) var data    : ArrayList<Dataxs> = arrayListOf()
)


data class Dataxs (
    @SerializedName("id"          ) var id         : Int?    = null,
    @SerializedName("id_pegawai"  ) var idPegawai  : String? = null,
    @SerializedName("id_kelas"    ) var idKelas    : String? = null,
    @SerializedName("hari"        ) var hari       : String? = null,
    @SerializedName("waktu"       ) var waktu      : String? = null,
    @SerializedName("jenis_kelas" ) var jenisKelas : String? = null,
    @SerializedName("created_at"  ) var createdAt  : String? = null,
    @SerializedName("updated_at"  ) var updatedAt  : String? = null
)