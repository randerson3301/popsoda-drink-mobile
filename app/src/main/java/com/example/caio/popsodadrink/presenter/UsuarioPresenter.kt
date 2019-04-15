package com.example.caio.popsodadrink.presenter

import com.example.caio.popsodadrink.model.ApiResult
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.view.UsuarioView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class UsuarioPresenter(internal var view: UsuarioView, internal var service: PopsService) {

    fun cadastrarUsuario(usuario: Usuario) {

        service.cadastrarUsuario(usuario).enqueue(object : Callback<ApiResult> {

            override fun onResponse(call: Call<ApiResult>?, response: Response<ApiResult>?) {

                val result = response?.body()

                view.showMessage("Sucesso", "Usuário cadastrado com sucesso!")

            }

            override fun onFailure(call: Call<ApiResult>?, t: Throwable?) {

                t?.printStackTrace()

                view.showMessage("Falha", "Erro ao fazer o cadastro!")

            }

        })

    }

    fun loginUsuario(usuario: Usuario){
        service.loginUsuario(usuario).enqueue(object: Callback<Usuario>{
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                val result = response?.body()

                view.login("Funcionou!")
            }

            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()
                view.login("Não Funcionou!")
            }
        })
    }
}


