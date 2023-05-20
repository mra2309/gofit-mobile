package com.example.myapplication.model.response

import com.google.gson.annotations.SerializedName


public class JadwalHarianResponse {
    @SerializedName("success")
    var success: Boolean? = null;
    @SerializedName("message")
    var message: String? = null;
    @SerializedName("data")
    var data: MutableList<Datum?>? = ArrayList()
}

class Datum {
    @SerializedName("id"                 ) var id               : Int?    = null;
    @SerializedName("id_jadwal_harian"   ) var idJadwalHarian   : String? = null;
    @SerializedName("id_pegawai"         ) var idPegawai        : String? = null;
    @SerializedName("id_kelas"           ) var idKelas          : String? = null;
    @SerializedName("tanggal"            ) var tanggal          : String? = null;
    @SerializedName("hari_jadwal_harian" ) var hariJadwalHarian : String? = null;
    @SerializedName("waktu"              ) var waktu            : String? = null;
    @SerializedName("jenis_kelas"        ) var jenisKelas       : String? = null;
    @SerializedName("keterangan_kelas"   ) var keteranganKelas  : String? = null;
    @SerializedName("created_at"         ) var createdAt        : String? = null;
    @SerializedName("updated_at"         ) var updatedAt        : String? = null;
}
