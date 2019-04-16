package com.example.caio.popsodadrink.service

import com.example.caio.popsodadrink.model.ApiResult
import com.example.caio.popsodadrink.model.Brinde
import com.example.caio.popsodadrink.model.Login
import com.example.caio.popsodadrink.model.Usuario
import retrofit2.Call
import retrofit2.http.*


interface PopsService {

    @POST("/user/add")
    fun cadastrarUsuario(@Body usuario: Usuario): Call<ApiResult>

    @FormUrlEncoded
    @POST("/user/login")
    fun loginUsuario(
            //parametros necessários para retornar os dados do Usuario logado
            @Field("user") username: String,
            @Field("password")password: String
            ): Call<Usuario>

    @GET("/brinde")
    fun getBrindes(): Call<Brinde>

}