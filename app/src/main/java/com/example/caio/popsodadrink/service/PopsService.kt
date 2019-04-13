package com.example.caio.popsodadrink.service

import com.example.caio.popsodadrink.model.ApiResult
import com.example.caio.popsodadrink.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface PopsService {

    @POST("/user/add")
    fun cadastrarUsuario(@Body usuario: Usuario): Call<ApiResult>

}