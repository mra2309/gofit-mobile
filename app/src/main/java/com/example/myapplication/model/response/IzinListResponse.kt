package com.example.myapplication.model.response

import com.google.gson.annotations.SerializedName

public class IzinListResponse {
    @SerializedName("success")
    var success: Boolean? = null;

    @SerializedName("message")
    var message: String? = null;

    @SerializedName("data")
    var data: MutableList<Data?>? = ArrayList()
}

class Data {
    @SerializedName("id"               ) var id             : Int?    = null;
    @SerializedName("id_instruktur"    ) var idInstruktur   : String? = null;
    @SerializedName("id_jadwal_harian" ) var idJadwalHarian : String? = null;
    @SerializedName("nama_instruktur"  ) var namaInstruktur : String? = null;
    @SerializedName("tanggal_izin"     ) var tanggalIzin    : String? = null;
    @SerializedName("keterangan_izin"  ) var keteranganIzin : String? = null;
    @SerializedName("sesi_izin"        ) var sesiIzin       : String? = null;
    @SerializedName("id_pegawai"       ) var idPegawai      : String? = null;
    @SerializedName("status"           ) var status         : String? = null;
    @SerializedName("created_at"       ) var createdAt      : String? = null;
    @SerializedName("updated_at"       ) var updatedAt      : String? = null;
}
