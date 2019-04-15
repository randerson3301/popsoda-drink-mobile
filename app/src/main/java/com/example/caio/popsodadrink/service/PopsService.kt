package com.example.caio.popsodadrink.service

import com.example.caio.popsodadrink.model.ApiResult
import com.example.caio.popsodadrink.model.Brinde
import com.example.caio.popsodadrink.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET


interface PopsService {

    @POST("/user/add")
    fun cadastrarUsuario(@Body usuario: Usuario): Call<ApiResult>

    @POST("/user/login")
    fun loginUsuario(@Body usuario: Usuario): Call<Usuario>

    @GET("/brinde")
    fun getBrindes(): Call<Brinde>

}