package com.example.myapplication.model.response

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("message"      ) var message     : String?      = null,
    @SerializedName("user"         ) var user        : User?        = User(),
    @SerializedName("token_type"   ) var tokenType   : String?      = null,
    @SerializedName("access_token" ) var accessToken : AccessToken? = AccessToken()
)

data class User (
    @SerializedName("id"                ) var id              : Int?    = null,
    @SerializedName("id_user"           ) var idUser          : String? = null,
    @SerializedName("name"              ) var name            : String? = null,
    @SerializedName("tanggal_lahir"     ) var tanggalLahir    : String? = null,
    @SerializedName("email"             ) var email           : String? = null,
    @SerializedName("email_verified_at" ) var emailVerifiedAt : String? = null,
    @SerializedName("role"              ) var role            : String? = null,
    @SerializedName("created_at"        ) var createdAt       : String? = null,
    @SerializedName("updated_at"        ) var updatedAt       : String? = null
)

data class AccessToken (
    @SerializedName("name"           ) var name          : String?           = null,
    @SerializedName("abilities"      ) var abilities     : ArrayList<String> = arrayListOf(),
    @SerializedName("expires_at"     ) var expiresAt     : String?           = null,
    @SerializedName("tokenable_id"   ) var tokenableId   : Int?              = null,
    @SerializedName("tokenable_type" ) var tokenableType : String?           = null,
    @SerializedName("updated_at"     ) var updatedAt     : String?           = null,
    @SerializedName("created_at"     ) var createdAt     : String?           = null,
    @SerializedName("id"             ) var id            : Int?              = null
)

