package com.example.caio.popsodadrink.presenter

import com.example.caio.popsodadrink.model.ApiResult
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.view.CadastroView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class CadastroPresenter(internal var view: CadastroView, internal var service: PopsService) {

    fun cadastrarUsuario(usuario: Usuario) {

        service.cadastrarUsuario(usuario).enqueue(object : Callback<ApiResult> {

            override fun onResponse(call: Call<ApiResult>?, response: Response<ApiResult>?) {

                val result = response?.body()

            }

            override fun onFailure(call: Call<ApiResult>?, t: Throwable?) {

                t?.printStackTrace()

            }

        })

    }
}