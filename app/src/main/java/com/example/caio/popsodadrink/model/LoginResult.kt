package com.example.caio.popsodadrink.model

import com.google.gson.annotations.SerializedName

class LoginResult (
        @SerializedName("id_p_fisica")
        var userId: Int,
    @SerializedName("name")
    var nome: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("cpf")
    var cpf: String,

    @SerializedName("user")
    var login: String
    )