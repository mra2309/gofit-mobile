package com.example.myapplication.model.response

import com.google.gson.annotations.SerializedName

data class BookingGymResponse (
    @SerializedName("success" ) var success : Boolean?        = null,
    @SerializedName("message" ) var message : String?         = null,
    @SerializedName("data"    ) var data    : ArrayList<Datax> = arrayListOf()
)


data class Datax (
    @SerializedName("id_gym"     ) var idGym     : String? = null,
    @SerializedName("bulan"      ) var bulan     : String? = null,
    @SerializedName("tanggal"    ) var tanggal   : String? = null,
    @SerializedName("waktu"      ) var waktu     : String? = null,
    @SerializedName("slot_waktu" ) var slotWaktu : String? = null,
    @SerializedName("sisa_kuota" ) var sisaKuota : Int?    = null,
    @SerializedName("id_member"  ) var idMember  : String? = null,
    @SerializedName("nama"       ) var nama      : String? = null,
    @SerializedName("status"     ) var status    : String? = null,
    @SerializedName("created_at" ) var createdAt : String? = null,
    @SerializedName("updated_at" ) var updatedAt : String? = null
)